import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no2186 {
	static int d[][][];
	static char map[][];
	static int N, M, K;
	
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		map = new char[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= str.length(); j++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		String answer = br.readLine();
		d = new int[N+1][M+1][answer.length()+1];
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == answer.charAt(0)) {
//					d[i][j] = 0;
					cnt += dfs(1, i,j, answer);
//					printView();
				}
			}
		}
		System.out.println(cnt);
		
	}
	void printView() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(d[i][j] + " ");
			}System.out.println();
		}
	}
	int dfs(int index, int x, int y, String answer) {
//		visited[x][y] = true;
		if (index == answer.length()) return d[x][y][index] = 1;
		if (d[x][y][index] != 0) return d[x][y][index];		
		int dx[] = {1, -1, 0, 0};
		int dy[] = {0, 0, 1, -1};
		for (int k = 1; k <= K; k++) {
			for (int i = 0; i < 4; i++) {
				int move_x = dx[i]*k + x;
				int move_y = dy[i]*k + y;
				if (move_x > 0 && move_y > 0 && move_x <= N && move_y <= M) {
					char c = map[move_x][move_y];
					if (answer.charAt(index) == c) {
						d[x][y][index] += dfs(index+1, move_x, move_y, answer);
						
						printView();
//						for (int q = 1; q <= N; q++) {
//							for (int w = 1; w <= M; w++) {
//								System.out.print(visited[q][w] + " ");
//							}System.out.println();
//						}
						System.out.println();
					}
				}
			}
		}
		return d[x][y][index];
	}
	public static void main(String[] args) throws IOException{
		new no2186().init();
	}
}
