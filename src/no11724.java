import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class no11724 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		Vector<Integer> v[] = new Vector[N+1];
		for (int i = 1; i <= N; i++) v[i] = new Vector<Integer>();
		for (int i = 1; i <= M; i++) {
			String str[] = br.readLine().split(" ");
			int to = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			v[to].add(end);
			v[end].add(to);
		}
		boolean visited[] = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) Collections.sort(v[i]);
		int count = 0 ;
		for (int i = 1; i <= N; i++) {
			if (visited[i] == false) {				
//				dfs(v, visited, i);
				bfs(v,visited,i);
				count ++;
			}
		}
		System.out.println(count);
	}
	void dfs(Vector<Integer> v[], boolean visited[], int x) {
		if (visited[x]) return ;
		visited[x] = true;
		for (int i = 0; i < v[x].size(); i++) {
			int next = v[x].get(i);
			if (visited[next] == false)
				dfs(v, visited, next);
		}
	}
	void bfs(Vector<Integer> v[], boolean visited[], int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i = 0; i < v[x].size(); i++) {
				int next = v[x].get(i);
				if (visited[next] == false) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new no11724().init();
	}
}
