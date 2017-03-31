import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class no11567 {
	class Point {
		int x,y;
		int map[][];
		int count;
		Point(int x, int y, int[][] map, int count) {
			this.x = x;
			this.y = y;
			this.map = map;
			this.count = count;
		}
	}
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int map[][] = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = input.charAt(j-1) == 'X' ? 1 : 0;
			}
		}
		str = br.readLine().split(" ");
		int start_x = Integer.parseInt(str[0]);
		int start_y = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int end_x = Integer.parseInt(str[0]);
		int end_y = Integer.parseInt(str[1]);
	}
	void bfs(int N, int M, int[][] map, int start_x, int start_y, int end_x, int end_y) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(start_x, start_y, map,0));
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		while (!q.isEmpty()) {			
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int count = p.count;
			for (int i = 0 ; i < 4; i++) {
				int ch_map[][] = new int[N+1][M+1];
				ch_map = initMap(p.map, ch_map, N, M);
				int move_x = x + dx[i];
				int move_y = y + dy[i];
				if (move_x > 0 && move_y > 0 && move_x <= N && move_y <= M && ch_map[move_x][move_y] == 0) {
					ch_map[move_x][move_y] = 1;
					if (move_x == start_x && move_x == start_y && count == 1) // 안됨.
					{} else {						
						q.offer(new Point(move_x, move_y, ch_map, count+1));
					}
					
				}
			}
		}
	}
	int[][] initMap(int ori_map[][], int ch_map[][], int N, int M) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				ch_map[i][j] = ori_map[i][j];
			}
		}
		return ch_map;
	}
	public static void main(String[] args) throws IOException {
		new no11567().init();
	}
}
