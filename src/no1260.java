import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class no1260 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int E = Integer.parseInt(input[0]);
		int V = Integer.parseInt(input[1]);
		int start = Integer.parseInt(input[2]);
		ArrayList<Integer>[] map = (ArrayList<Integer>[])new ArrayList[E+1];
		for (int i = 0; i <= E; i++) map[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < V; i++) {
			String str[] = br.readLine().split(" ");
			int to = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			map[to].add(end);
			map[end].add(to);
		}
		for (int i = 1; i <= E; i++) Collections.sort(map[i]);
		boolean visited[] = new boolean[E+1];
		dfs(visited,map,start);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(visited, map, start);
		System.out.println();
	}
	void dfs(boolean visited[], ArrayList<Integer> map[], int x) {
		if (visited[x]) return;
		visited[x] = true;
		System.out.print(x + " ");
		for (int i : map[x]) {
			if (visited[i] == false) dfs(visited, map, i);
		}
	}
	void bfs(boolean visited[], ArrayList<Integer> map[], int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");
			for (int i : map[x]) {
				if (visited[i] == false) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new no1260().init();
	}
}
