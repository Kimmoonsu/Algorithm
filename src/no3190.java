import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class no3190 {
	class Point {
		int x, y;
		Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int map[][] = new int[N+1][N+1];
		for (int i = 1; i <= K; i++) {
			String str[] = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			map[x][y] = 1; // apple
		}
		int dir_count = Integer.parseInt(br.readLine());
		int dir_arr[][] = new int[dir_count+1][2];
		for (int i = 1; i <= dir_count; i++) {
			String str[] = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			dir_arr[i][0] = x;
			switch (str[1].charAt(0)) {
			case 'L' : dir_arr[i][1] = 1;
			break;
			case 'D' : dir_arr[i][1] = 2;
			break;
			}
		}
		System.out.println(play(map, N, dir_arr, dir_count, 1));
	}
	int play(int map[][], int N, int dir_arr[][], int dir_count, int time) {
		Queue<Point> q = new LinkedList<Point>();
		int x = 1, y = 1;
		map[x][y] = 2;
		q.offer(new Point(x,y));
		int dx[] = {1,-1,0,0};
		int dy[] = {0, 0, 1,-1,};
		int index = 1;
		int move_count = dir_arr[index][0];
		int dir = dir_arr[index][1];
		int cur_dir = 2;
		int move_x = x;
		int move_y = y;
		
		while (true) {
			move_x += dx[cur_dir];
			move_y += dy[cur_dir];
			if (move_x > 0 && move_y > 0 && move_x <= N && move_y <= N && map[move_x][move_y] <= 1) {
				if (map[move_x][move_y] == 0) {
					Point p = q.poll();
					map[p.x][p.y] = 0;
				}
				map[move_x][move_y] = 2;
				q.offer(new Point(move_x, move_y));
			} else {
				return time;
			}
			if (index <= dir_count) {
				if (time == dir_arr[index][0]) {
					if (index < dir_count) {						
						cur_dir = changeDir(cur_dir, dir);
						index++;
						dir = dir_arr[index][1];
					} else if (index == dir_count) {
						cur_dir = changeDir(cur_dir, dir);
						index++;
					}
				}
			} 
			time++;
		}
		
	}
	int changeDir(int dir, int state) {
		if (state == 1) {// L 
			switch (dir) {
			case 0 : return 2;
			case 1 : return 3;
			case 2 : return 1;
			case 3 : return 0;
			}
		} else if (state == 2) {
			switch(dir) {
			case 0 : return 3;
			case 1 : return 2;
			case 2 : return 0;
			case 3 : return 1;
			}
		}
		return dir;
	}
	void print(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {		
		new no3190().init();
	}
}
/*
10
4
1 2
1 3
1 4
1 5
4
8 D
10 D
11 D
13 L




10
5
1 5
1 3
1 2
1 6
1 7
4
8 D
10 D
11 D
13 L
*/
