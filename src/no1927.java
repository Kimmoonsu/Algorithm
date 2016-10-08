import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class no1927  {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		func(q, N);
	}
	void func(PriorityQueue<Integer> q, int N) throws IOException {
		StringBuilder sb = new StringBuilder();
		while(N-- > 0) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				
				sb.append(q.isEmpty() == true ? ""+0 : ""+q.poll());
				sb.append("\n");
			}else {
				q.offer(input);
			}
		}
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		new no1927().init();		
	}
}
