import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no1057 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int A = Integer.parseInt(str[1]);
		int B = Integer.parseInt(str[2]);
		System.out.println(func(A, B));
	}
	int func(int A, int B) {
		int cnt = 0;
		while (A != B) {
			A -= A/2;
			B -= B/2;
			cnt ++;
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		new no1057().init();
	}
}
