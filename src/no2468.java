import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2468 {
	int cur_x;
	int cur_y;
	int count;
	int key = 0;
	boolean[][] visited;
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		int max_value = 1;
		for (int i = 1; i <= N; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(str[j-1]);
				map[i][j] = num;
				max_value = max_value >= num ? max_value : num;
			}
		}
		int max = 0;
		while (key ++ != max_value) {
			block(map, N);
			int ch_map[][] = new int[N+1][N+1];
			mapInit(map, ch_map, N);
			boolean state = true;
			while (state) {				
				state = find(ch_map, N);
				if (!state) {
					break;
				}
				dfs(ch_map, N, cur_x, cur_y);
				count ++;
			}
			max = max >= count ? max : count;
			count = 0;
		}
		System.out.println(max == 0 ? 1 : max);
	}
	void block(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] <= key) map[i][j] = 0;
			}
		}
	}
	boolean find(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0) {
					cur_x = i;
					cur_y = j;
					return true;
				}
			}
		}
		return false;
	}
	void mapInit(int map[][], int ch_map[][], int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ch_map[i][j] = map[i][j];
			}
		}
	}
	void print(int ch_map[][], int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(ch_map[i][j] + " ");
			}System.out.println();
		}
	}
	void dfs(int ch_map[][], int N, int x, int y) {
		ch_map[x][y] = 0;
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		for (int i = 0; i < 4; i++) {
			int move_x = dx[i] + x;
			int move_y = dy[i] + y;
			if (move_x > 0 && move_y > 0 && move_x <= N && move_y <= N && ch_map[move_x][move_y] != 0) {
				dfs(ch_map, N, move_x, move_y);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		new no2468().init();
	}
}