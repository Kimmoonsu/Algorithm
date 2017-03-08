import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class no14442 {
	class Point {
		int x, y, cnt;
		int state;
		Point(int x, int y, int cnt, int state) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.state = state;
		}
	}
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		int map[][] = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= str.length(); j++) {
				map[i][j] = (int)str.charAt(j-1)-48;
			}
		}
		System.out.println(bfs(map,N,M,K));
	}
	int bfs(int[][] map, int N, int M, int K) {
		Queue<Point> q = new LinkedList<Point>();
		boolean visited[][][] = new boolean[N+1][M+1][K+1];
		visited[1][1][0] = true;
		q.offer(new Point(1,1,1,0));
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		
		while (!q.isEmpty()) {			
			Point p = q.poll();
			int cnt = p.cnt;
			int state = p.state;
			for (int i = 0; i < 4; i++) {				
				if (p.x == N && p.y == M) return cnt; 
				int move_x = p.x + dx[i];
				int move_y = p.y + dy[i];
				
				if (move_x > 0 && move_y > 0 && move_x <= N && move_y <= M && !visited[move_x][move_y][state]) {
					if (map[move_x][move_y] == 0) {
						visited[move_x][move_y][state] = true;
						q.offer(new Point(move_x, move_y, cnt+1, state));
					} else if (map[move_x][move_y] == 1){
						if (state != K){
							q.offer(new Point(move_x, move_y, cnt+1, state+1));
							visited[move_x][move_y][state+1] = true;							
						}
					}
				}
			}
		}
		
		return -1;
	}
	public static void main(String[] args) throws IOException {
		new no14442().init();
	}
}
