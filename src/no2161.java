import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class no2161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++)
			queue.add(i);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
			if (queue.isEmpty()) break;
			int poll_n = queue.poll();
			queue.add(poll_n);
		}
	}
}
