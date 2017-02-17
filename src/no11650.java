import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class no11650 {
	class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class ComparatorAscending implements Comparator<Point> {
		
		public int compare(Point p1, Point p2) {
			if (p1.x < p2.x) {
				return -1;
			} else if (p1.x == p2.x) {
				if (p1.y < p2.y) {
					return -1;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}

	}

	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> q = new PriorityQueue<Point>(
				new ComparatorAscending());
		Point point = null;
		for (int i = 1; i <= N; i++) {
			String input[] = br.readLine().split(" ");
			point = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			q.add(point);
		}
		 printArr(q, N);
	}

	void printArr(PriorityQueue<Point> q, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			Point point = q.poll();
			sb.append(point.x + " " + point.y + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		new no11650().init();
	}
}
