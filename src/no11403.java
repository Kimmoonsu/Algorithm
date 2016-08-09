import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class no11403 {
	int arr[][] = new int[101][101];
	int G[][] = new int[101][101];
	boolean visited[];
	void init() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				arr[i][j] = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			bfsSearch(N, i);
			checkPath(N, i);
		}
		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
				System.out.print(G[i][j] + " ");
			System.out.println();
		}	
	}
	void bfsSearch(int N, int v)
	{
		visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		while(!q.isEmpty()) {
			v = (int)q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[v][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	void checkPath(int N, int v)
	{
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				G[v][i] = 1;
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		new no11403().init();
	}
}
