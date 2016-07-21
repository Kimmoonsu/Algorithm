import java.math.BigInteger;
import java.util.Scanner;


public class no9507 {
	BigInteger d[];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 0; t < testcase; t++)
		{
			int num = sc.nextInt();
			d = new BigInteger[68];
			for (int i = 0; i <= num; i++)
				d[i] = new BigInteger("0");
			System.out.println(koong(num));
		}
	}
	BigInteger koong(int n) {
		if (n < 2) return d[n] = new BigInteger("1");
		if (n == 2) return d[n] = new BigInteger("2");
		if (n == 3) return d[n] = new BigInteger("4");
		if (d[n].compareTo(new BigInteger("0")) == 1) return d[n];
		return d[n] = koong(n - 1).add(koong(n - 2)).add(koong(n - 3)).add(koong(n - 4));
	}
	public static void main(String[] args) {
		new no9507().init();
	}
}
