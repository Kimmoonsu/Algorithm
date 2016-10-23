import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no1780 {
	int map[][];
	int cnt[] = new int[3];
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) map[i][j] = Integer.parseInt(input[j-1]);
		}
		solve(1,1,N);
		for (int i = 0 ; i < 3; i ++) System.out.println(cnt[i]);
	}
	void solve(int x, int y, int n) {
		if (same(x, y, n)) {
			cnt[map[x][y]+1] += 1;
			return ;
		}
		int m = n/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0 ; j < 3; j++) {
				solve(x+i*m, y+j*m, m);
			}
		}
	}
	boolean same(int x, int y, int n) {
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (map[i][j] != map[x][y]) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException  {
		new no1780().init();
	}
}
