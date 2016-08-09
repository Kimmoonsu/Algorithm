import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class no2589 {
	void init() {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		sc.nextLine();
		int map[][] = new int[51][51];
		for (int i = 1; i <= X; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'W') map[i][j+1] = 0;
				else if (str.charAt(j) == 'L') map[i][j+1] = 1;				
			}
		}
		int cnt = 0;
		for (int i = 1; i <= X; i++) {
			for (int j = 1; j <= Y; j++) {
				if (map[i][j] == 1) {
					int num = bfs(i, j, X, Y, map);
					cnt = cnt < num ? num : cnt;
				}
			}
		}
		System.out.println(cnt-1);
	}
	int bfs(int start_x, int start_y, int X, int Y, int[][] map) {
		int change_map[][] = new int[51][51];
		for (int i = 1; i <= X; i++)
			for (int j = 1; j <= Y; j++) change_map[i][j] = map[i][j];
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		Queue<Integer> X_q = new LinkedList<Integer>();
		Queue<Integer> Y_q = new LinkedList<Integer>();
		boolean visited[][] = new boolean[51][51];
		X_q.offer(start_x);
		Y_q.offer(start_y);
		while(!X_q.isEmpty()) {
			int x = X_q.poll();
			int y = Y_q.poll();
			for (int i = 0 ; i < 4; i++) {
				if (x+dx[i] > 0 && x+dx[i] <= X && y+dy[i] > 0 && y+dy[i] <= Y && !visited[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]] == 1) {
					visited[x+dx[i]][y+dy[i]] = true;
					change_map[x+dx[i]][y+dy[i]] = change_map[x][y]+1;
					X_q.offer(x+dx[i]);
					Y_q.offer(y+dy[i]);
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= X; i++) {
			for (int j = 1; j <= Y; j++) {
				cnt = cnt < change_map[i][j] ? change_map[i][j] : cnt;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		new no2589().init();		
	}
}
