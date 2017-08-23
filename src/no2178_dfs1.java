import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class no2178_dfs1 {
	int dx[] = {0,0,1,-1};
	int dy[] = {1,-1,0,0};
	int dp[][];
	int resultCount = Integer.MAX_VALUE;
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int map[][] = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for (int i = 1 ; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1 ; j <= M; j++) {
				map[i][j] = str.charAt(j-1) - 48;
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		boolean visited[][] = new boolean[N+1][M+1];
		visited[1][1] = true;
		dfs(1, 1, 1, visited, N, M, map);
		System.out.println(resultCount);
	}
	void dfs(int x, int y, int count, boolean visited[][], int N, int M, int map[][]) {
		if (dp[x][y] < count) return;
		dp[x][y] = count;
		if (N == x && M == y) {
			resultCount = resultCount < count ? resultCount : count;
			return ;
		}
		for (int i = 0 ; i < 4; i ++) {
			int move_x = dx[i] + x;
			int move_y = dy[i] + y;
			if (move_x > 0 && move_y > 0 && move_x <= N && move_y <= M && !visited[move_x][move_y] && map[move_x][move_y] == 1) {
				visited[move_x][move_y] = true;
				dfs(move_x, move_y, count+1, visited, N, M, map);
				visited[move_x][move_y] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new no2178_dfs1().init();
	}
}
