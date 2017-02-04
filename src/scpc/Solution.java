package scpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	int inf = 100000001;
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			sb.append("Case #"+t+"\n");
			String input[] = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);
			int map[][] = new int[N+1][N+1];
			for (int i = 1; i <= N ; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = inf;
				}
			}
			for (int i = 1; i <= M; i++) {
				input = br.readLine().split(" ");
				int r = Integer.parseInt(input[0]);
				int c = Integer.parseInt(input[1]);
				int value = Integer.parseInt(input[2]);
				if (map[r][c] < 0) {
					map[r][c] = value;
					map[c][r] = value;
				}
				else if (map[r][c] > value) {
					map[r][c] = value;
					map[c][r] = value;
				}
			}
//			for (int i = 1; i <= N ; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}
			int P = Integer.parseInt(br.readLine());
			int total = 0;
			for (int i = 1; i <= P; i++) {
				input = br.readLine().split(" ");
				int start = Integer.parseInt(input[0]);
				int end = Integer.parseInt(input[1]);
				int dist = dikstra(map, start, N)[end];
				total = K >= dist ? total : total+1;
			}
			sb.append(total+"\n");
		}
		System.out.println(sb);
	}
	int[] dikstra(int map[][], int start, int N)
	{
		boolean[] visited = new boolean[N+1];
		int dist[] = new int[N+1];
		int nextVertex = start;
		int min = inf;
		for (int i = 1; i <= N; i++)
			dist[i] = inf;
		dist[start] = 0;
		
		while(true)
		{
			min = inf;
			for (int j = 1; j <= N; j++)
			{
				if (!visited[j] && dist[j] < min)
				{
					nextVertex = j;
					min = dist[j];
				}
			}
			if (min == inf) break;
			visited[nextVertex] = true;
			
			for (int j = 1; j <= N; j++)
			{
				int distanceVertex = dist[nextVertex] + map[nextVertex][j];
				if (dist[j] > distanceVertex)
					dist[j] = distanceVertex;
			}
		}
		return dist;
	}
	public static void main(String[] args) throws IOException {
		new Solution().init();
	}
}
