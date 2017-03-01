import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1890 {
	static long d[][];
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N+1][N+1];
		d = new long[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 1; j <= input.length; j++) {				
				map[i][j] = Integer.parseInt(input[j-1]);
			}
		}
		System.out.println(jump(map, N, 1,1));
		
	}
	
	long jump(int map[][], int N, int x, int y) {
		
		if (x == N  && y == N) return 1;
		if (x > N || y > N) return 0;
		if (d[x][y] != 0) return d[x][y];
		int jumpsize = map[x][y];
		if (jumpsize != 0) {
			d[x][y] += jump(map, N, x+jumpsize, y);
			d[x][y] += jump(map, N, x, y+jumpsize);
		}
		return d[x][y];
	}
	public static void main(String[] args) throws IOException {
		new no1890().init();
	}
}
