import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class no1759 {
	StringBuilder sb = new StringBuilder();
	String input[];
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int L = Integer.parseInt(str[0]);
		int C = Integer.parseInt(str[1]);
		input = new String[L];
		String c[] = br.readLine().split(" ");
		Arrays.sort(c);
		dp(c, L, C, 0, 0, 0, 0);
		System.out.println(sb);
	}
	boolean isMo(char a) {
		if (a == 'a' || a == 'e' || a == 'i' ||
		        a == 'o' || a == 'u' ) return true;
		    else return false;
	}
	void dp(String str[],int L, int C, int cur, int len, int ja, int mo) {
		if (len == L) {
			if (ja >= 2 && mo >= 1) {
				for (int i = 0; i < L; i++) sb.append(input[i]);
				sb.append("\n");
			}return;
		} 
		for (int i = cur; i < C; i++) {
			input[len] = str[i];
			dp(str, L, C, i+1, len + 1, ja + (!isMo(str[i].charAt(0)) ? 1 : 0), mo + (isMo(str[i].charAt(0)) ? 1 : 0));
		}
	}
	public static void main(String[] args) throws IOException {
		new no1759().init();
	}
}
