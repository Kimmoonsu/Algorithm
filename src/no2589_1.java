import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class no2589_1 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int map[][] = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				map[i][j + 1] = input.charAt(j) == 'W' ? 0 : 1;
			}
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1) {
					int cnt = bfs(i,j, N, M, map);
					result = cnt > result ? cnt : result;
				}
			}
		}
		System.out.println(result-1);
	}

	int bfs(int start_x, int start_y, int N, int M, int[][] map) {
		Queue<Integer> x_queue = new LinkedList<Integer>();
		Queue<Integer> y_queue = new LinkedList<Integer>();
		int board[][] = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) 
			for (int j = 1; j <= M; j++) board[i][j] = map[i][j];
		boolean visited[][] = new boolean[N+1][M+1];
		int x = 0, y = 0;
		x_queue.offer(start_x);
		y_queue.offer(start_y);
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		int max = 0;
		while (!x_queue.isEmpty()) {
			x = x_queue.poll();
			y = y_queue.poll();
			visited[x][y] = true;
			for (int i = 0 ; i < 4; i++) {
				int move_x = dx[i] + x;
				int move_y = dy[i] + y;
				if (move_x > 0 && move_x <= N && move_y > 0 && move_y <= M && !visited[move_x][move_y] && board[move_x][move_y] == 1) {
					x_queue.offer(move_x);
					y_queue.offer(move_y);
					board[move_x][move_y] = board[x][y] + 1;
					max = board[move_x][move_y] < max ? max : board[move_x][move_y];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		new no2589_1().init();
	}
}
