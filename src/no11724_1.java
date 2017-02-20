import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;


public class no11724_1 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		Vector<Integer>[] map = new Vector[N+1];
		for (int i = 1; i <= N; i++) map[i] = new Vector<Integer>();
		for (int i = 0; i < M; i++) {
			String str[] = br.readLine().split(" ");
			int to = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			map[to].add(end);
			map[end].add(to);
		}
		boolean visited[] = new boolean[N+1];
		for (int i = 1; i <= N; i++)
			Collections.sort(map[i]);	
		System.out.println(printCount(map, N, visited));
		
	}
	void test(boolean visited[]) {
		visited[1] = true;
	}
	void test2(boolean visited[]) {
		System.out.println(visited[1]);
	}
	int printCount (Vector<Integer>[] map, int N, boolean visited[]) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(map, i, visited);
				count ++;
			}
		}
		return count;
	}
	void dfs(Vector<Integer>[] map, int node, boolean visited[]) {
		if (visited[node]) return;
		visited[node] = true;
		for (int i = 0; i < map[node].size(); i++) {
			int next = map[node].get(i);
			if (!visited[next]) dfs(map, next, visited);
		}
	}
	public static void main(String[] args) throws IOException {
		new no11724_1().init();
	}
}
