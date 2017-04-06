import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;


public class no1389 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		Vector<Integer> v[] = new Vector[N+1];
		int map[][] = new int[N+1][N+1];
		boolean visited[] = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			v[i] = new Vector<Integer>();
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		for (int i = 1; i <= M; i++) {
			str = br.readLine().split(" ");
			int to = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			v[to].add(end);
			v[end].add(to);
		}
		int min = 0;
		int total = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			dfs(v, visited, N, i, map, i, 0);
			int sum = rowSum(map, N, i);
			if (total > sum) {
				total = sum;
				min = i;
			}
		}
		System.out.println(min);
	}
	void print(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
	}
	int rowSum(int map[][], int N, int x) {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += map[x][i];
		}
		return sum;
	}
	void dfs(Vector<Integer> v[], boolean visited[], int N, int x, int map[][], int cur, int count) {
		map[cur][x] = Math.min(map[cur][x], count); 
		visited[x] = true;
		for (int i = 0; i < v[x].size(); i++) {
			int next = v[x].get(i);
			if (!visited[next]) {				
				dfs(v, visited, N, next, map, cur, count+1);
				visited[next] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new no1389().init();
	}
}
