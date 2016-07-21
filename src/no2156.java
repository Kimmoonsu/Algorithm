import java.math.BigInteger;
import java.util.Scanner;


public class no2156 {
	int a[];
	BigInteger d[];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		d = new BigInteger[10001];
		for (int i = 0; i <= 10000; i++)
				d[i] = new BigInteger("0");
		a = new int[num+1];
		for (int i = 1 ; i <= num; i ++)
			a[i] = sc.nextInt();
		d[1] = new BigInteger(""+a[1]);
		if (num >= 2)
		{
			int temp = a[1]+a[2];
			d[2] = new BigInteger(""+temp);
		}
		
		System.out.println(dp(num));
		
	}
	BigInteger max(BigInteger a, BigInteger b, BigInteger c)
	{
		if (a.compareTo(b) == 1)
		{
			if (a.compareTo(c) == 1) return a;
			else return c;
		}
		else
		{
			if (b.compareTo(c) == 1) return b;
			else return c;
		}
	}
	BigInteger dp(int n)
	{
		for (int i = 3; i <= n; i++)
		{
			d[i] = max(d[i-1], d[i-2].add(new BigInteger(""+a[i])), d[i-3].add(new BigInteger(""+a[i-1])).add(new BigInteger(""+a[i])));
		}
		return d[n];
	}
	public static void main(String[] args) {
		new no2156().init();
	}
}
