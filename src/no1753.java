import java.util.Scanner;


public class no1753 {
	int d[][] = new int[20001][20001];
	final int inf = 10000001;
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();
		//d = new int[V+1][V+1];
		for (int i = 1; i <= V; i++)
			for (int j = 1; j <= V; j++)
				d[i][j] = inf;
		for (int i = 1; i <= E; i++)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			int value = sc.nextInt();
			if (d[r][c] < 0) d[r][c] = value;
			else if (d[r][c] > value) d[r][c] = value;
		}
		sc.close();
		int dist[] = dikstra(start,V,E);
		for (int i = 1; i <= V; i++)
			System.out.println(dist[i] ==inf ? "INF" : dist[i]);
	}
	int[] dikstra(int start, int V, int E)
	{
		boolean[] visited = new boolean[20001];
		int dist[] = new int[20001];
		int nextVertex = start;
		int min = inf;
		for (int i = 1; i <= V; i++)
			dist[i] = inf;
		dist[start] = 0;
		
		while(true)
		{
			min = inf;
			for (int j = 1; j <= V; j++)
			{
				if (!visited[j] && dist[j] < min)
				{
					nextVertex = j;
					min = dist[j];
				}
			}
			if (min == inf) break;
			visited[nextVertex] = true;
			
			for (int j = 1; j <= V; j++)
			{
				int distanceVertex = dist[nextVertex] + d[nextVertex][j];
				if (dist[j] > distanceVertex)
					dist[j] = distanceVertex;
			}
		}
		return dist;
	}
	public static void main(String[] args) {
		new no1753().init();
	}
}
