import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no2875 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // girls
		int M = Integer.parseInt(input[1]); // boys
		int K = Integer.parseInt(input[2]); 
		System.out.println(func(N, M, K));
	}
	int func(int N, int M, int K) {
		int result = 0;
		while (N >= 2 && M >= 1 && N+M >= K+3) {
			N -= 2;
			M -= 1;
			result ++;
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		new no2875().init();
	}
}
