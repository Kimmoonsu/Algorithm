import java.math.BigInteger;
import java.util.Scanner;


public class scpc_2016_2 {
	BigInteger d[][];
	BigInteger total_d[];
	int a[];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++)
		{
			System.out.println("Case #" + t);
			d = new BigInteger[50001][101];
			total_d = new BigInteger[50001];
			a = new int[50001];
			int N = sc.nextInt();
			int K = sc.nextInt();
			for (int i = 0; i <= N; i++)
				total_d[i] = new BigInteger("0");
			for (int i = 0; i <= N; i++)
				for (int j = 0; j<=K; j++)
					d[i][j] = new BigInteger("0");
			int L = sc.nextInt();
			for (int i = 1; i <= L; i++)
			{
				a[sc.nextInt()] = -1;
			}
			System.out.println(func(N,K));
		}
	}
	BigInteger func(int N, int K)
	{
		for (int i = 1; i <= K; i++)
			if (a[i] != -1) d[i][i] = new BigInteger("1");
		for (int i = 3; i <= N; i++)
		{
			for (int j = 1; j <= K; j++)
			{
				if (i-j>=0 && a[i-j] != -1 && total_d[i-j].compareTo(new BigInteger("0"))==0) {
					for (int k = 1; k <= K; k++)
					{
						//total_d[i-j] = total_d[i-j].add(d[i-j][k]);
						if (j != k) {	
							d[i][j] = (d[i][j].add(d[i-j][k]));
						}
					}
				}
				else if (i-j >= 0 && a[i-j] != -1){
					d[i][j] = total_d[i-j].subtract(d[i-j][j]);
				}
				total_d[i] = total_d[i].add(d[i][j]);
			}
		}
		BigInteger total = new BigInteger("0");
		for (int i = 1; i <= K; i++)
			total = total.add(d[N][i]);
		return total.mod(new BigInteger("1000000009"));
	}
	public static void main(String[] args) {
		new scpc_2016_2().init();
	}
}
