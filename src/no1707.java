import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class no1707 {
	Vector<Integer>[] v;
	int color[];
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0 ; i < testcase; i++) {
			String str[] = br.readLine().split(" ");
			int V = Integer.parseInt(str[0]);
			v = new Vector[V+1];
			color = new int[V+1];
			for (int j = 0; j <= V; j++) v[j] = new Vector();
			int E = Integer.parseInt(str[1]);
			for (int j = 0; j < E; j++) {
				String input[] = br.readLine().split(" ");
				int next = Integer.parseInt(input[0]);
				int to = Integer.parseInt(input[1]);
				v[next].add(to);
				v[to].add(next);
			}
			for (int j = 1; j <= V; j++) {
				if (color[j] == 0)
					dfs(j, 1); 
			}
			boolean state = true;
			for (int j = 1; j <= V; j++) {
				for (int k = 0; k < v[j].size(); k++) {
					int next = v[j].get(k);
					if (color[j] == color[next]) state = false;
				}
			}
			System.out.println(state == true ? "YES"  : "NO");
		}
	}
	void dfs(int node, int c) {
		color[node] = c;
		for (int i = 0; i < v[node].size(); i++) {
			int next = v[node].get(i);
			if (color[next] == 0)
				dfs(next, 3-c);
		}
	}
	public static void main(String[] args) throws IOException {
		new no1707().init();
	}
}
