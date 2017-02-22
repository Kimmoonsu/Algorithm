import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class no10451 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			Vector<Integer>[] map = new Vector[N+1];
			for (int i = 1; i <= N; i++) map[i] = new Vector<Integer>();
			String input[] = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				map[i].add(Integer.parseInt(input[i-1]));
			}
			boolean visited[] = new boolean[N+1];
			sb.append(printCycle(map, visited, N)+"\n");
		}
		System.out.println(sb);
	}
	int printCycle(Vector<Integer>[] map, boolean visited[], int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) count += bfs(map, visited, i);
		}
		return count;
	}
	int bfs(Vector<Integer>[] map, boolean visited[], int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(node);
		visited[node] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
			visited[x] = true;
			int next = map[x].get(0);
			if (visited[next]) return 1;
			else q.offer(next);
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		new no10451().init();
	}
}
