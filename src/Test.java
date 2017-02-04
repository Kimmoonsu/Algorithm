import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test {
	public static void main(String[] args) {
		int N = 20;
		int map[][] = new int[N+1][N+1];
		map[0][1] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
		System.out.println(map[N][N]);
	}
}
