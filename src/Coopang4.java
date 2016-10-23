import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Coopang4 {
	void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= testcase; i++) {
			String str[] = br.readLine().split(" ");
			sb.append(solution(str[0], str[1]) +"\n");
		}
		System.out.println(sb);
	}
	int solution(String A, String B) {
		int A_index[] = new int[A.length()];
		int B_index[] = new int[B.length()];
		if (A.length() != B.length()) return -1;
		int A_cnt = 0, B_cnt = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'a') {
				A_index[A_cnt] = i;
				A_cnt++;
			}
			if (B.charAt(i) == 'a') {
				B_index[B_cnt] = i;
				B_cnt++;
			}
		}
		int total = 0;
		for (int i = 0; i < A_index.length; i++) {
			total += Math.abs(A_index[i] - B_index[i]);
		}
		return total;
	}
	public static void main(String[] args) throws IOException{
		new Coopang4().init();
	}
}
