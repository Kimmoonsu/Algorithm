import java.math.BigInteger;
import java.util.Scanner;


public class no10844 {
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
		for (int i = 1; i <= 9; i++)
			d[1][i] = new BigInteger("1");
		System.out.println(dp(n).mod(new BigInteger("1000000000")));
	}
	BigInteger dp(int n)
	{
		if (n != 1)
		{
			for (int i = 2; i <= n; i++)
			{
				for (int j = 0; j <= 9; j++)
				{
					if (j==0) d[i][j] = d[i][j].add(d[i-1][j+1]);
					else if (j==9) d[i][j] = d[i][j].add(d[i-1][j-1]);
					else d[i][j] = d[i-1][j-1].add(d[i-1][j+1]);	
				} 
			}
			BigInteger temp = new BigInteger("0");
			for (int i = 0; i <= 9; i++)
			{
				temp = temp.add(d[n][i]);
			}
			return temp;	
		}
		return new BigInteger("9");
		
	}
	public static void main(String[] args) {
		new no10844().init();
	}
}
