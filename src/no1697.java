import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class no1697 {
	class Point {
		int position;
		int count;
		Point(int position, int count) {
			this.position = position;
			this.count = count;
		}
	}
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int subin = Integer.parseInt(input[0]);
		int sister = Integer.parseInt(input[1]);
		System.out.println(bfs(subin, sister));
	}
	int bfs(int subin, int sister) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(subin, 0));
		boolean visited[] = new boolean[100001];
		visited[subin] = true;
		int dx[] = {2, 1, -1};
		while (!q.isEmpty()) {
			Point point = q.poll();
			for (int i = 0; i < 3; i++) {
				int count = point.count+1;
				int next = point.position;
				if (next == sister) return count-1;
				next = i == 0 ? next * 2 : next + dx[i];
				if (next >= 0 && next <= 100000 && !visited[next]) {
					q.offer(new Point(next, count));
					visited[next] = true;
				}
			}
		}
		return 1;
	}
	public static void main(String[] args) throws IOException {
		new no1697().init();
	}
}
