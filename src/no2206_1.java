import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class no2206_1 {
	int X, Y;
	boolean map[][] = new boolean[1001][1001];
	boolean visited[][][] = new boolean[1001][1001][2];
	boolean isPass = false;
	int short_cnt = 1;
	
	class Node {
		int x, y;
		int cnt;
		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		X = Integer.parseInt(str[0]);
		Y = Integer.parseInt(str[1]);
		for (int i = 1; i <= X; i++) {
			String map_str = br.readLine();
			for (int j = 0; j < map_str.length(); j++) {
				if (map_str.charAt(j) == '0') map[i][j+1] = false;
				else map[i][j+1] = true;
			}
		}
		BFS_all(1,1);
		if (isPass) System.out.println(short_cnt);
		else System.out.println("-1");
	}
	void BFS_all(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(x, y, 1));
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size -- > 0) {
				BFS(queue, queue.poll());
				if (isPass) return;
			}
			short_cnt++;
		}
		
	}
	void BFS(Queue<Node> q, Node node) {
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		
		int x = node.x;
		int y = node.y;
		int cnt = node.cnt;
		if (x == X && y == Y) {
			isPass = true;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (x+dx[i] > 0 && x+dx[i] <= X && y+dy[i] > 0 && y+dy[i] <= Y && visited[x+dx[i]][y+dy[i]][cnt] == false) {
				if (map[x+dx[i]][y+dy[i]] == false) {
					q.offer(new Node(x+dx[i], y+dy[i], cnt));
					visited[x+dx[i]][y+dy[i]][cnt] = true;
				}
				else {
					if (cnt == 1) {
						q.offer(new Node(x+dx[i], y+dy[i], cnt-1));
						visited[x+dx[i]][y+dy[i]][cnt-1] = true;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new no2206_1().init();
	}
}
