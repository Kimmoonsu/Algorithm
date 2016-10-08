import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class no1931 {
	class Point implements Comparable<Point> {
		int begin, end;
		Point(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
		@Override
		public int compareTo(Point o) {
			if (this.end == o.end)
				return this.begin < o.begin? -1 : 1;
			else return this.end < o.end ? -1 : 1;
		}
	}
	void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> p = new PriorityQueue<Point>();
		for (int i = 0 ; i < N; i++) {
			String str[] = br.readLine().split(" ");
			p.add(new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}
		System.out.println(greedy(p));
	}
	int greedy(PriorityQueue<Point> p) {
		int now = 0;
		int ans = 0;
		while (!p.isEmpty()) {
			int begin = p.peek().begin;
			int end = p.poll().end;
			if (now <= begin) {
				now = end;
				ans += 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException{
		new no1931().init();
	}
}
