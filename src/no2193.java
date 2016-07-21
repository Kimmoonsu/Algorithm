import java.math.BigInteger;
import java.util.Scanner;


public class no2193 {
	BigInteger d[][];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		d = new BigInteger[91][2];
		for (int i = 0 ; i <= num; i++)
		{
			for (int j = 0 ; j < 2; j++)
				d[i][j] = new BigInteger("0");
		}
		d[1][0] = new BigInteger("1");
		d[1][1] = new BigInteger("1");
		d[2][0] = new BigInteger("1");
		d[2][1] = new BigInteger("1");
		System.out.println(dp(num));
	}
	BigInteger dp(int n)
	{
		if (n>=3)
		{
			for (int i = 3; i <= n; i++)
			{
				for (int j = 0; j <= 1; j++)
				{
					if (j == 0) d[i][j] = d[i-1][0].add(d[i-1][1]);
					else if (j == 1) d[i][j] = d[i][j].add(d[i-1][0]);
				}
			}
			BigInteger temp = d[n][0].compareTo(d[n][1]) == 1 ? d[n][0] : d[n][1];
			return temp;
		}
		else
			return new BigInteger("1");
	}
	public static void main(String[] args) {
		new no2193().init();
	}
}
