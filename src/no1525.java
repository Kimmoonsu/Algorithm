import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class no1525 {
	
	class Point {
		int arr[][] = new int[4][4];
		int count = 0;
		int blank[] = new int[2];
		
		Point(int arr[][], int count, int blank[]) {
			this.arr = arr;
			this.count = count;
			this.blank = blank;
		}
	}
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int map[][] = new int[4][4];
		for (int i = 1; i <= 3; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 1; j <= 3; j++) map[i][j] = Integer.parseInt(input[j-1]);
		}
		int blank[] = findBlank(map);
		System.out.println(bfs(map, blank));
	}
	int[] findBlank(int[][] map) {
		int blank[] = new int[2];
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (map[i][j] == 0) {
					blank[0] = i;
					blank[1] = j;
					break;
				}
			}
		}
		return blank;
			 
	}
	int finishCheck(int[][] map) {
		int count = 1;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (count == 9) return 1;
				if (map[i][j] == count) count++;
				else return -1;
			}
		}
		return 1;
	}
	boolean isVisited(Set<ArrayList<Integer>> set, int[][] move_arr) {
		ArrayList<Integer> value = new ArrayList<Integer>();
		
		for (int i = 1; i <= 3; i ++) {
			for (int j = 1; j <= 3; j ++) {
				value.add(move_arr[i][j]);
			}
		}
		if (set.contains(value)) {
			return true;
		} else {
			set.add(value);
			return false;
		}
	}
	int bfs(int[][] map, int blank[]) {
		if (finishCheck(map) == 1) return 0;
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(map, 0, blank));
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> value = new ArrayList<Integer>();
		for (int i = 1; i <= 3; i ++) {
			for (int j = 1; j <= 3; j ++) {
				value.add(map[i][j]);
			}
		}
		set.add(value);
		while (!q.isEmpty()) {
			Point point = q.poll();
			
			for (int i = 0 ; i < 4; i ++) {
				int move_x = point.blank[0] + dx[i];
				int move_y = point.blank[1] + dy[i];

				if (move_x > 0 && move_x <= 3 && move_y > 0 && move_y <= 3) {
					int move_arr[][] = new int[4][4];
					move_arr = insert(move_arr, point.arr);
					move_arr[move_x-dx[i]][move_y-dy[i]] = move_arr[move_x][move_y];
					move_arr[move_x][move_y] = 0;
					if (!isVisited(set, move_arr)) {// 같은게 없으면 false
						int check = finishCheck(move_arr);
						if (check == 1) return point.count+1;
						int move_blank[] = new int[2];
						move_blank[0] = move_x;
						move_blank[1] = move_y;
						q.offer(new Point(move_arr, point.count+1, move_blank));
					}
				}
			}
		}
		return -1;
	}
	int[][] insert(int move_arr[][], int arr[][]) {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				move_arr[i][j] = arr[i][j];
			}
		}
		return move_arr;
	}
	public static void main(String[] args) throws IOException {
		new no1525().init();
	}
}
