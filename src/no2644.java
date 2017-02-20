import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class no2644 {
	static int to = 0, end = 0;
	static boolean state = false;
	static int result = 0;
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		to = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);
		int m = Integer.parseInt(br.readLine());
		Vector<Integer>[] family = new Vector[N+1];
		for (int i = 1; i <= N; i++) family[i] = new Vector<Integer>();
		for (int i = 1; i <= m; i++) {
			String str[] = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			family[x].add(y);
			family[y].add(x);
		}
		boolean visited[] = new boolean[N+1];
		System.out.println(dfs(family, visited, to, 0) == 1 ? result : -1);
	}
	int dfs(Vector<Integer>[] family, boolean visited[], int current_node, int count) {
		if (state) return 1;
		visited[current_node] = true;
		if (current_node == end) {
			state = true;
			result = count;
			return 1;
		}
		for (int i = 0; i < family[current_node].size(); i++) {
			int next = family[current_node].get(i);
			if (!visited[next]) {
				dfs(family, visited, next, count+1);
				if (state) return 1;
			}
		}
		return state == true ? 1 : -1;
		
	}
	public static void main(String[] args) throws IOException {
		new no2644().init();
	}
}
