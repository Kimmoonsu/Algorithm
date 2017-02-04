import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no2747 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int fibo_arr[] = new int[N+1];
		System.out.println(fibo(N));
	}
	int fibo(int N, int fibo_arr[]) {
		if (N <= 2) fibo_arr[N] = 1;
		if (fibo_arr[N] == 0) 
			fibo_arr[N] = fibo(N-1, fibo_arr) + fibo(N-2, fibo_arr);
		return fibo_arr[N];
	}
	int fibo(int N) {
		int fibo_arr[] = new int[N+1];
		fibo_arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			fibo_arr[i] = fibo_arr[i-1] + fibo_arr[i-2];
		}
		return fibo_arr[N];
	}
	public static void main(String[] args) throws IOException {
		new no2747().init();
	}
}
