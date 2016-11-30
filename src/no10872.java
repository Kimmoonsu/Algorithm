import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no10872 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = factorial(N);
		System.out.println(result);
	}
	int factorial(int N) {
		if (N <= 1) return 1;
		return N * factorial(N-1);
	}
	public static void main(String[] args) throws IOException {
		new no10872().init();
	}
}
