import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class no1726 {
	class Point {
		int x,y,cnt,dir;
		Point(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int map[][] = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 1; j <= str.length; j++) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		input = br.readLine().split(" ");
		int start_x = Integer.parseInt(input[0]);
		int start_y = Integer.parseInt(input[1]);
		int start_dir = Integer.parseInt(input[2]);
		input = br.readLine().split(" ");
		int finish_x = Integer.parseInt(input[0]);
		int finish_y = Integer.parseInt(input[1]);
		int finish_dir = Integer.parseInt(input[2]);
		System.out.println(bfs(map, N, M, start_x, start_y, start_dir, finish_x, finish_y, finish_dir));
	}
	int bfs(int map[][], int N, int M, int start_x, int start_y, int start_dir, int finish_x, int finish_y, int finish_dir) {
		boolean visited[][][] = new boolean[N+1][M+1][5];
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(start_x, start_y, 0, start_dir));
		visited[start_x][start_y][start_dir] = true;
		int dx[] = {0,0,0,1,-1};
		int dy[] = {0,1,-1,0,0};
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			int dir = p.dir;
			if (x == finish_x && y == finish_y && dir == finish_dir) return cnt;
			for (int i = 1; i <= 3; i++) {
				int move_x = x + dx[dir] * i;
				int move_y = y + dy[dir] * i;
				if (move_x > 0 && move_y > 0 && move_x <= N && move_y <= M && map[move_x][move_y] == 0) {
					if (!visited[move_x][move_y][dir]) {						
						visited[move_x][move_y][dir] = true;
						q.offer(new Point(move_x, move_y, cnt+1, dir));
					}
				}
				else break;
			}
			
			for (int i = 1 ; i <= 4; i ++) {
				if (reverseDir(dir) != i && dir != i && !visited[x][y][i]) {
					visited[x][y][i] = true;
					q.offer(new Point(x, y, cnt+1, i));
				}
			}
		}
		return -1;
	}
	int	reverseDir(int dir) {
		switch (dir) {
		case 1 : return 2;
		case 2 : return 1;
		case 3 : return 4;
		case 4 : return 3;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		new no1726().init();
	}
}
