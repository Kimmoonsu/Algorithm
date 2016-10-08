import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2169 {
	int d[][] = new int[1005][1005];
	void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str [] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int map[][] = new int[1005][1005];
		int map2[][] = new int[1005][1005];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = st.countTokens();
			for (int j = 1; j <= cnt; j++) {
				int value = Integer.parseInt(st.nextToken(" "));
				map[i][j] = value;
				map2[i][j] = value;
			}
		}
		System.out.println(dp(N, M, map, map2));
	}
	int dp(int N, int M, int map[][], int map2[][]) {
		d[1][1] = map[1][1];
		
		for (int i = 1; i <= M; i++) {
			map[1][i] += map[1][i-1];
			map2[1][i] += map2[1][i-1];
			d[1][i] = map[1][i];
		}
		for (int i = 2; i <= N; i++) {
			map[i][1] += map[i-1][1];
			for (int j = 2; j <= M; j++) 
				map[i][j] = map[i][j] + Math.max(map[i][j-1], map[i-1][j]);
			map2[i][M] += map2[i-1][M];
			for (int j = M-1; j >= 1; j--)
				map2[i][j] = map2[i][j] + Math.max(map2[i][j+1], map2[i-1][j]);
			for (int j = 1; j <= M; j++) {
				d[i][j] = Math.max(map[i][j], map2[i][j]);
			}
			for (int j = 1; j <= M; j++) {
				map[i][j] = d[i][j];
				map2[i][j] = d[i][j]; 
			}
		}
		return d[N][M];
	}
	public static void main(String[] args) throws IOException {
		new no2169().init();
	}
}
