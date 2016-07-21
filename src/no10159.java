import java.util.Scanner;

public class no10159 {
	int d[][];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		d = new int[N+1][N+1];
		for (int i = 1; i <= M; i++)
		{
			int big = sc.nextInt();
			int small = sc.nextInt();
			d[big][small] = 1;
			d[small][big] = -1;
		}
		find(N);
		for (int i = 1; i <= N; i++)
		{
			int sum = 0;
			for (int j = 1; j <= N; j++)
			{
				//System.out.print(d[i][j] + " ");
				sum = (i != j && d[i][j] == 0) ? sum+1 : sum;	
			}
			//System.out.println();
			System.out.println(sum);
		}
	}
	void find(int N)
	{
		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
			{
				if (d[i][j] == 1)
				{
					for (int k = 1; k <= N; k++)
					{
						if (d[j][k] == 1) {
							d[i][k] = 1;
							d[k][i] = -1;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new no10159().init();
	}
}
