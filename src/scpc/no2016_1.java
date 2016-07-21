package scpc;

import java.math.BigInteger;
import java.util.Scanner;

public class no2016_1 {
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++)
		{
			int K = sc.nextInt();
			System.out.println("Case #" + t);
			System.out.print(min(K) +" " + max(K));
			System.out.println();
		}
	}
	BigInteger min(int K)
	{
		BigInteger min = new BigInteger("1");
		for (int i = 1; i <= K; i++)
		{
			BigInteger num = (min.subtract(new BigInteger("1"))).divide(new BigInteger("3"));
			if (((min.subtract(new BigInteger("1"))).mod(new BigInteger("3")).compareTo(new BigInteger("0"))) == 0 && num.compareTo(new BigInteger("1"))==1) {
				min = num.compareTo(new BigInteger("0"))==1 ? num : min.multiply(new BigInteger("2"));
			}
			else {
				min = min.multiply(new BigInteger("2"));
			}
		}
		return min;
	}
	BigInteger max(int K)
	{
		BigInteger max = new BigInteger("1");
		for (int i = 1; i <= K; i++)
		{
			max = max.multiply(new BigInteger("2"));
		}
		return max;
	}
	public static void main(String[] args) {
		new no2016_1().init();
	}
}
