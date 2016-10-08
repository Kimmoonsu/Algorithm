import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class no11279 {
	class Priority implements Comparable<Priority> {
		int count;
		public Priority(int count) {
			this.count = count;
		}
		@Override
		public int compareTo(Priority o) {
			if (this.count > o.count) return -1;
			else if (this.count < o.count) return 1;
			else return 0;
		}
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void init() throws IOException{
		int N = Integer.parseInt(br.readLine());
		func(N);
	}
	void func(int N) throws IOException {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Priority> q = new PriorityQueue<Priority>();
		while (N-- > 0) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				sb.append(q.isEmpty()==true ? ""+0 : ""+q.poll().count);
				sb.append("\n");
			}else q.offer(new Priority(input));
		}
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		new no11279().init();
	}
}
