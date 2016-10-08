import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no11047 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int coin[] = new int[N];
		for (int i = 0; i < N; i++) coin[i] = Integer.parseInt(br.readLine());
		System.out.println(func(N, K, coin));
	}
	int func(int N, int K, int[] coin) {
		int cnt = 0;
		for (int i = N-1; i >= 0; i--) {
			cnt += K / coin[i];
			K %= coin[i];
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		new no11047().init();
	}
}
