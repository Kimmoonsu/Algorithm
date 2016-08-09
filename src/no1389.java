import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class no1389 {
	int arr[][] = new int[101][101];
	int relation[][] = new int[101][101];
	boolean visited[];
	void init() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
	}
	void bfsSerach(int N, int v) {
		visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		while (!q.isEmpty()) {
			v = (int)q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[v][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	public static void main(String[] args) {
		new no1389().init();
	}
}
