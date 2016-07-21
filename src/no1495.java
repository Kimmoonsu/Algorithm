import java.util.Scanner;


public class no1495 {
	int d[][];
	int a[];
	int M;
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		M = sc.nextInt();
		d = new int[101][M+1];
		a = new int[N];
		for (int i = 0; i < N; i++)
		{
			a[i] = sc.nextInt();
		}
		for (int i = 0; i <= 100; i++)
			for (int j = 0; j <= M; j++)
				d[i][j] = -2;
		d[0][S] = -1;
		System.out.println(dp(N, S, M));
	}
	int dp(int n, int s, int m)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j <= m; j++)
			{
				if (d[i][j] == i-1) {
					if (j + a[i] <= m) d[i+1][j+a[i]] = i;
					if (j - a[i] >= 0) d[i+1][j-a[i]] = i;
				}
			}
		}
		for (int i = m; i >= 0; i--)
		{
			if (d[n][i] == n-1) return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		new no1495().init();
	}
}
