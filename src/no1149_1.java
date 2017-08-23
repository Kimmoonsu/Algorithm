import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no1149_1 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N+1][4];
		int d[][] = new int[N+1][4];
		for (int i = 1; i <= N; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		System.out.println(dp(N, map, d));
	}
	int dp(int N, int map[][], int d[][]) {
		for (int i = 1; i <= N; i++) {
			d[i][1] = Math.min(d[i-1][2], d[i-1][3]) + map[i][1];
			d[i][2] = Math.min(d[i-1][1], d[i-1][3]) + map[i][2];
			d[i][3] = Math.min(d[i-1][1], d[i-1][2]) + map[i][3];
		}
		return Math.min(Math.min(d[N][1], d[N][2]), d[N][3]); 
	}
	public static void main(String[] args) throws IOException {
		new no1149_1().init();
	}
}
