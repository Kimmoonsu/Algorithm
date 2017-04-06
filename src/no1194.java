import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class no1194 {
	class Point {
		int x, y, count, state;

		Point(int x, int y, int count, int state) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.state = state;
		}
	}

	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int map[][] = new int[N + 1][M + 1];
		int start_x = 0, start_y = 0;
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				switch (input.charAt(j - 1)) {
				case '.':
					map[i][j] = 0;
					break;
				case '#':
					map[i][j] = 1;
					break;
				case '0':
					start_x = i;
					start_y = j;
					break;
				case '1':
					map[i][j] = -1;
					break;
				default:
					map[i][j] = (int) input.charAt(j - 1);
				}
			}
		}
		
		System.out.println(bfs(map, N, M, start_x, start_y));
	}

	int bfs(int map[][], int N, int M, int start_x, int start_y) {
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		boolean visited[][][] = new boolean[N+1][M+1][65];
		visited[start_x][start_y][0] = true;
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(start_x, start_y, 0, 0));
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0 ; i < 4; i++) {
				int state = p.state;
				int count = p.count;
				int move_x = p.x + dx[i];
				int move_y = p.y + dy[i];
				if (move_x > 0 && move_x <= N && move_y > 0 && move_y <= M && !visited[move_x][move_y][state]) {
					if (map[move_x][move_y] >= 97) { //  key
						state = state | (1 << (map[move_x][move_y] - 97));
						visited[move_x][move_y][state] = true;
						q.offer(new Point(move_x, move_y, count+1, state));
					} else if (map[move_x][move_y] >= 65) { // my key
						if ( (state & ( 1 << (map[move_x][move_y] - 65) )) != 0) { 
							visited[move_x][move_y][state] = true;
							q.offer(new Point(move_x, move_y, count+1, state));
						}
					} else if (map[move_x][move_y] == -1) return count+1;
					else if (map[move_x][move_y] == 0) {
						visited[move_x][move_y][state] = true;
						q.offer(new Point(move_x, move_y, count+1, state));
					}
				}
			}
		}
		return -1;
	}

	void print(int map[][], int N, int M) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		new no1194().init();
	}
}
