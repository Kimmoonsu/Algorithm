import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no9465 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[3][N+1];
			int dp[][] = new int[3][N+1];
			for (int i = 1; i <= 2; i++) {				
				String input[] = br.readLine().split(" ");
				for (int j = 1; j <= N; j++) map[i][j] = Integer.parseInt(input[j-1]);
			}
			func(map, dp, N);
			System.out.println(max(dp, N));
		}
	}
	void func(int map[][], int dp[][], int N) {
		dp[1][1] = map[1][1];
		dp[2][1] = map[2][1];
		for (int j = 2; j <= N; j++) {
			for (int i = 1; i <= 2; i++) {
				if (i == 1) {
					dp[i][j] = Math.max(dp[i+1][j-1], dp[i][j-2]);
					dp[i][j] = Math.max(dp[i][j], dp[i+1][j-2]);
				}
				else if (i == 2) {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-2]);
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-2]);
				}
				dp[i][j] += map[i][j];
			}
		}
	}
	int max(int dp[][], int N) {
		int max = 0;
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= N; j++) {
				max = max < dp[i][j] ? dp[i][j] : max;
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException {
		new no9465().init();
	}
}
