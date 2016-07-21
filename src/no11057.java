import java.math.BigInteger;
import java.util.Scanner;


public class no11057 {
	BigInteger d[][];
	
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new BigInteger[n+1][11];
		for (int i = 0 ; i <= n; i++)
		{
			for (int j = 0 ; j <= 10; j++)
				d[i][j] = new BigInteger("0");
		}
		for (int i = 0; i <= 9; i++)
			d[1][i] = new BigInteger("1");
		System.out.println(dp(n).mod(new BigInteger("10007")));
	}
	BigInteger dp(int n)
	{
		for (int i = 2; i <= n; i++)
		{
			for (int j = 0; j <= 9; j++)
			{
				for (int k = 0; k <= j; k++)
				d[i][j] = d[i][j].add(d[i-1][k]);
			} 
		}
		BigInteger temp = new BigInteger("0");
		for (int i = 0; i <= 9; i++)
		{
			temp = temp.add(d[n][i]);
		}
		return temp;	
	}
	public static void main(String[] args) {
		new no11057().init();
	}
}

