package ac.kr.DataStructure;

import java.util.Scanner;

public class Dijkstra {
	// #include <stdio.h>
	//
	// #define N 100
	// #define INF 100000
	//
	final int N = 1000000;
	final int INF = 100000;
	int a[][] = new int[N + 1][N + 1];
	int visit[] = new int[N + 1];
	int dist[] = new int[N + 1];
	int start, end;
	int n, m;

	// input 값 sample
	// 첫번째 라인에는 정점의 개수, 그리고 시작 정점, 도착 정점이 입력
	// 두번째 라인에는 정점별 간선의 입력받을 가중치의 개수(m)가 입력된다.
	// 세번째 라인부터는 정점별 간선의 입력받을 가중치가 m번이 들어온다.

	/*
	 
	7 1 7
	9
	1 2 4
	1 3 2
	2 4 1
	2 5 2
	3 4 7
	3 6 3
	4 7 3
	5 7 1
	6 7 5
	 
	*/

	void input() {
		Scanner sc = new Scanner(System.in);
		int i, j;
		int from, to;
		int w;
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();

		// 각 정점으로 가는 간선의 가중치를 무한대로 초기화한다.(최소값을 구하기위해)
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				if (i != j)
					a[i][j] = INF;

		for (i = 1; i <= m; i++) // 정점에서 정점으로 가는 간선의 가중치가 입력
		{
			from = sc.nextInt();
			to = sc.nextInt();
			w = sc.nextInt();
			a[from][to] = w;
		}
		for (i = 1; i <= n; i++)
			dist[i] = INF;
		dijkstra();
		for (i = 1 ; i <= n; i++)
		{
			if (dist[i] == INF)
				System.out.println("INF");
			else
				System.out.printf("%d \n", dist[i]);
		}
	}

	void dijkstra() {
		int i, j;
		int min;
		int v = 0;

		dist[start] = 0; // 시작점의 거리 0

		for (i = 1; i <= n; i++) {
			min = INF;
			for (j = 1; j <= n; j++) {
				if (visit[j] == 0 && min > dist[j]) // 갈수 있는 정점중에 가장 가까운 정점 선택
				{
					min = dist[j];
					v = j;
				}
			}

			visit[v] = 1; // 가장 가까운 정점으로 방문, i정점에서 가장 가까운 최단경로 v

			for (j = 1; j <= n; j++) {
				if (dist[j] > dist[v] + a[v][j]) // 방문한 정점을 통해 다른 정점까지의 거리가
													// 짧아지는지 계산하여 누적된값 저장
					dist[j] = dist[v] + a[v][j];
			}
		}
	}

	public static void main(String[] args) {
		new Dijkstra().input();

	}
}
