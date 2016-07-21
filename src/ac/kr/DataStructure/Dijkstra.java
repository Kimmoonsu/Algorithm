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

	// input �� sample
	// ù��° ���ο��� ������ ����, �׸��� ���� ����, ���� ������ �Է�
	// �ι�° ���ο��� ������ ������ �Է¹��� ����ġ�� ����(m)�� �Էµȴ�.
	// ����° ���κ��ʹ� ������ ������ �Է¹��� ����ġ�� m���� ���´�.

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

		// �� �������� ���� ������ ����ġ�� ���Ѵ�� �ʱ�ȭ�Ѵ�.(�ּҰ��� ���ϱ�����)
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				if (i != j)
					a[i][j] = INF;

		for (i = 1; i <= m; i++) // �������� �������� ���� ������ ����ġ�� �Է�
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

		dist[start] = 0; // �������� �Ÿ� 0

		for (i = 1; i <= n; i++) {
			min = INF;
			for (j = 1; j <= n; j++) {
				if (visit[j] == 0 && min > dist[j]) // ���� �ִ� �����߿� ���� ����� ���� ����
				{
					min = dist[j];
					v = j;
				}
			}

			visit[v] = 1; // ���� ����� �������� �湮, i�������� ���� ����� �ִܰ�� v

			for (j = 1; j <= n; j++) {
				if (dist[j] > dist[v] + a[v][j]) // �湮�� ������ ���� �ٸ� ���������� �Ÿ���
													// ª�������� ����Ͽ� �����Ȱ� ����
					dist[j] = dist[v] + a[v][j];
			}
		}
	}

	public static void main(String[] args) {
		new Dijkstra().input();

	}
}
