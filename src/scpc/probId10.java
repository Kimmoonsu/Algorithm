package scpc;

import java.util.Scanner;

public class probId10 {
	static int dx[] = {0,1};
	static int dy[] = {1,0};
	void init() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			sb.append("Case #" + t + "\n");
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int map[][] = new int[N+1][M+1];
			int d[][] = new int[N+1][M+1];
			for (int i = 1; i <= K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if (x > 0 && x <= N && y > 0 && y <= M) map[x][y] = 1;
			}
			int count = dfs(map, N, M, d, 1, 1);
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
	int dfs(int[][] map, int N, int M, int d[][], int x, int y) {
		if (x == N && y == M) return d[x][y] = 1;
		if (d[x][y] != 0) return d[x][y];
		for (int i = 0; i < 2; i++) {
			int move_x = x+dx[i];
			int move_y = y+dy[i];
			if (move_x > 0 && move_y > 0 && move_x <= N && move_y <= M && map[move_x][move_y] == 0)
				d[x][y] += dfs(map, N, M, d, move_x, move_y) % 1000000007;
		}
		return d[x][y];
	}
	public static void main(String[] args) {		
		new probId10().init();
	}
}
