import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class no12851 {
	int min = Integer.MAX_VALUE;
	int total_count = 0;
	class Point {
		int x, cnt;
		Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		bfs(N,K);
		System.out.println(min);
		System.out.println(total_count);
	}
	void bfs(int N, int K) {
		if (N == K) {
			min = 0;
			total_count = 1;
		} else {
			
			Queue<Point> q = new LinkedList<Point>();
			q.offer(new Point(N, 0));
			boolean visited[]= new boolean[100001];
			int count[] = new int[100001];
			int dx[] = {2, 1,-1};
			while (!q.isEmpty()) {
				Point p = q.poll();
				int x = p.x;
				int cnt = p.cnt;
				for (int i = 0; i < 3; i++) {
					int move_x = x;
					if (i == 0) {
						move_x *= dx[i];
						
					} else {
						move_x += dx[i];
					}
					if (move_x == K) {
						if (min >=cnt+1) {
							min = cnt+1;
							total_count++;
						}
					}
					if ((move_x <= 100000 && move_x >= 0 )&& (!visited[move_x] || count[move_x] == cnt+1)) {
						q.offer(new Point(move_x, cnt+1));
						if (x != K) {							
							visited[move_x] = true;
							count[move_x] = cnt+1;
						}
					}
					
				}
		}
		}
		
}
	public static void main(String[] args) throws IOException {
		new no12851().init();
	}
}
