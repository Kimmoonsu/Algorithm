import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no2206 {
	private int dp[][][] = new int[1001][1001][3];
	private int map[][] = new int[1001][1001];
	Queue<Integer> wall_x = new LinkedList<Integer>();
	Queue<Integer> wall_y = new LinkedList<Integer>();
	int total = Integer.MAX_VALUE;
	private int X, Y;

	void init() {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= X; i++) {
			for (int j = 1; j <= Y; j++) {
				for (int k = 1; k <= 2; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 1; i <= X; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= Y; j++) {
				if (str.charAt(j - 1) == '1') {
					map[i][j] = -1;
					wall_x.offer(i);
					wall_y.offer(j);
				} else if (str.charAt(j - 1) == '0')
					map[i][j] = 0;
			}
		}
		System.out.println(bfs());
	}

	int bfs() {
		int x_state[] = { 1, 0, -1, 0 };
		int y_state[] = { 0, 1, 0, -1 };
		Queue<Integer> x_queue = new LinkedList<Integer>();
		Queue<Integer> y_queue = new LinkedList<Integer>();
		boolean visited[][] = new boolean[X + 1][Y + 1];
		int x = 1, y = 1;
		x_queue.offer(x);
		y_queue.offer(y);
		dp[x][y][0] = 1;
		dp[x][y][1] = 1;
		while (!x_queue.isEmpty()) {
			x = x_queue.poll();
			y = y_queue.poll();
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				
				if ((x + x_state[i]) <= X && (y + y_state[i]) <= Y
						&& (x + x_state[i]) > 0 && (y + y_state[i]) > 0
						&& visited[x + x_state[i]][y + y_state[i]] == false) {
					
					if (map[x + x_state[i]][y + y_state[i]] == 0) { //
						x_queue.offer((x + x_state[i]));
						y_queue.offer((y + y_state[i]));
						dp[(x + x_state[i])][(y + y_state[i])][0] = dp[x][y][0] + 1;	
					} 
					else {
						
					}
					
					
					//if (copy_map[(x + x_state[i])][(y + y_state[i])] > total) return Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 1; i <= X; i++) {
			for (int j = 1; j <=Y; j++) {
				System.out.print(dp[i][j][0]+ " ");
			}
			System.out.println();
		}
		return dp[X][Y][0];
	}
	
	public static void main(String[] args) {
		new no2206().init();
	}
}