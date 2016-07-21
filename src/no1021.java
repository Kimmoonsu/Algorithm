import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 다시 풀어야함 알고리즘은 대충 맞는데 시간초과 남(C+	+에서는 성공).

public class no1021 {
	
	public static void main(String[] args) throws Exception {
		Deque<Integer> deque = new ArrayDeque<Integer>(100);
		Deque<Integer> data = new ArrayDeque<Integer>(100);
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= N; i++)
			deque.offer(i);
		for (int i = 1; i <= M; i++)
			data.offer(sc.nextInt());
		while (!data.isEmpty()) {
//			Deque<Integer> first_d = new ArrayDeque<Integer>(100);
//			Deque<Integer> second_d = new ArrayDeque<Integer>(100);
//			first_d.addAll(deque);
//			second_d.addAll(deque);
//			int first_cnt = 0;
//			int second_cnt = 0;
			if (deque.getFirst() == data.getFirst()) {
				deque.pollFirst();
				data.pollFirst();
			}
			else if (Math.abs(deque.getFirst()+deque.size() - data.getFirst()) < Math.abs(deque.getFirst()-data.getFirst())) {
				while (deque.getFirst() != data.getFirst()) {
					int first = deque.pollLast(); 
					deque.offerFirst(first);
					cnt ++;
				}
			}
			else {
				while (deque.getFirst() != data.getFirst()) {
					int first = deque.pollFirst(); 
					deque.offerLast(first);
					cnt ++;	
				}
			}
		}
		System.out.println(cnt);
	}
	static class FastScanner {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int nextInt() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
