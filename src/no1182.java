import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no1182 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int S = Integer.parseInt(str[1]);
		int map[] = new int[N+1];
		str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(str[i]);
		}
		System.out.println(bitmaskFunc(map, N, S));
	}
	int bitmaskFunc(int map[], int N, int S) {
		int count = 0;
		for (int i = 1; i < (1 << N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ( (i & (1 << j)) != 0) {
					sum += map[j];
				}
			}
			if (sum == S) count ++; 
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		
		new no1182().init();
	}
}
