import java.util.Scanner;


public class no1916 {
	int d[][];
	final int inf = 100000001;
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int city = sc.nextInt();
		int bus = sc.nextInt();
		d = new int[city+1][city+1];
		for (int i = 1; i <= city; i++)
			for (int j = 1; j <= city; j++)
				d[i][j] = inf;
		for (int i = 1; i <= bus; i++)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			int value = sc.nextInt();
			if (d[r][c] < 0) d[r][c] = value;
			else if (d[r][c] > value) d[r][c] = value;
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		sc.close();
		System.out.println(dikstra(start,city,bus)[end]);
	}
	int[] dikstra(int start, int city, int bus)
	{
		boolean[] visited = new boolean[city+1];
		int dist[] = new int[city+1];
		int nextVertex = start;
		int min = inf;
		for (int i = 1; i <= city; i++)
			dist[i] = inf;
		dist[start] = 0;
		
		while(true)
		{
			min = inf;
			for (int j = 1; j <= city; j++)
			{
				if (!visited[j] && dist[j] < min)
				{
					nextVertex = j;
					min = dist[j];
				}
			}
			if (min == inf) break;
			visited[nextVertex] = true;
			
			for (int j = 1; j <= city; j++)
			{
				int distanceVertex = dist[nextVertex] + d[nextVertex][j];
				if (dist[j] > distanceVertex)
					dist[j] = distanceVertex;
			}
		}
		return dist;
	}
	public static void main(String[] args) {
		new no1916().init();
	}
}
