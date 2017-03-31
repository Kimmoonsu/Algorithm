import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class no12100 {
	long max_value = 0;
	
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(str[j - 1]);
			}
		}
		dfs(map, N, 0);
		System.out.println(max_value);
	}
	void dfs(int map[][], int N, int count) {		
		if (count == 5) {
			long max = maxValue(map, N);
			max_value = Math.max(max_value, max);
			return ;
		}
		for(int i = 0; i < 4; i++) {
			int ch_map[][] = new int[N+1][N+1];
			ch_map = mapInit(map, ch_map, N);
			switch (i) {
			case 0:
				ch_map = rightSlide(ch_map, N);				
				break;
			case 1:
				ch_map = leftSlide(ch_map, N);
				break;
			case 2:
				ch_map = downSlide(ch_map, N);
				break;
			case 3:
				ch_map = upSlide(ch_map, N);
				break;
			}
			dfs(ch_map, N, count+1);
		}
	}
	int[][] mapInit(int ori_map[][], int ch_map[][], int N) {
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				ch_map[i][j] = ori_map[i][j];
		return ch_map;
	}
	long maxValue(int map[][], int N) {
		long max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}
	
	
	int[][] leftSlide(int map[][], int N) {
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0) continue;
				else if (map[i][j] == map[i][j+1]) {
					map[i][j] += map[i][j+1];
					map[i][j+1] = 0;
				}
			}
			// 0을 앞으로 댕겨준다.
			for (int j = 2; j <= N; j++) {
				for (int k = j; k > 1; k--) {
					if (map[i][k] != 0 && map[i][k-1] == 0) {
						map[i][k-1] = map[i][k];
						map[i][k] = 0;
					} 
				}
			}
		}
		return map;
	}

	int[][] upSlide(int map[][], int N) {
		for (int j = 1; j <= N; j++) {
			for (int i = 1; i < N; i++) {
				if (map[i][j] == 0) continue;
				else if (map[i][j] == map[i+1][j]) {
					map[i][j] += map[i+1][j];
					map[i+1][j] = 0;
				}
			}
			// 0을 앞으로 댕겨준다.
			for (int i = 2; i <= N; i++) {
				for (int k = i; k > 1; k--) {
					if (map[k][j] != 0 && map[k-1][j] == 0) {
						map[k-1][j] = map[k][j];
						map[k][j] = 0;
					} 
				}
			}
		}
		return map;
	}
	int[][] rightSlide(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = N; j > 1 ; j--) {
				if (map[i][j] == 0) continue;
				else if (map[i][j] == map[i][j-1]) {
					map[i][j] += map[i][j-1];
					map[i][j-1] = 0;
				}
			}
			// 0을 앞으로 댕겨준다.
			for (int j = N-1; j >= 1; j--) {
				for (int k = j; k < N; k++) {
					if (map[i][k] != 0 && map[i][k+1] == 0) {
						map[i][k+1] = map[i][k];
						map[i][k] = 0;
					} 
				}
			}
		}
		return map;
	}
	int[][] downSlide(int map[][], int N) {
		for (int j = 1; j <= N; j++) {
			for (int i = N; i > 1 ; i--) {
				if (map[i][j] == 0) continue;
				else if (map[i][j] == map[i-1][j]) {
					map[i][j] += map[i-1][j];
					map[i-1][j] = 0;
				}
			}
			// 0을 앞으로 댕겨준다.
			for (int i = N-1; i >= 1; i--) {
				for (int k = i; k < N; k++) {
					if (map[k][j] != 0 && map[k+1][j] == 0) {
						map[k+1][j] = map[k][j];
						map[k][j] = 0;
					} 
				}
			}
		}
		return map;
	}

	public static void main(String[] args) throws IOException {
		new no12100().init();
	}
}