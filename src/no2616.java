import java.util.Scanner;


public class no2616 {
	int a[] = new int[50001];
	int s[] = new int[50001];
	int d[][] = new int[50001][4];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++)
		{
			a[i] = sc.nextInt();
			s[i] = s[i-1] + a[i];
		}
		int M = sc.nextInt();
		System.out.println(func(N,M));
	}
	int sum(int x, int y) {	return s[y] - s[x-1]; }

	int func(int N, int M)
	{
		// N -> °´Â÷ ÃÑ ±æÀÌ
		// M -> ÇÑ °´Â÷´ç ²ø ¼ö ÀÖ´Â ¼ö
		for (int j = 1; j <= 3; j++)
		{
			for (int i = M*j; i <= N; i++)
			{
				d[i][j] = d[i-1][j];
				d[i][j] = Math.max(d[i][j], d[i-M][j-1] + sum(i-M+1, i));
			}
		}
		return d[N][3];
	}
	public static void main(String[] args) {
		new no2616().init();
	}
}
