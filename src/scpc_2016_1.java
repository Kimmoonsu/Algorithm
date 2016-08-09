import java.math.BigInteger;
import java.util.Scanner;

public class scpc_2016_1 {
	int d[] = new int[10000];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		minfunc();
		for (int t = 1; t <= testcase; t++)
		{
			int K = sc.nextInt();
			System.out.println("Case #" + t);
			System.out.print(d[K]+" " + max(K));
			System.out.println();
		}
	}
	int func(int N)
	{
		int cnt = 0;
		while(N!=1)
		{
			if (N%2 == 0)
				N /= 2;
			else if (N%2 == 1)
				N = N*3+1;
			cnt ++;
		}
		return cnt;
	}
	void minfunc()
	{
		for (int i = 1; i <= 100000; i++)
		{
			int index = func(i);
			d[index] = d[index] == 0 || d[index] > i ? i : d[index]; 
		}
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
		new scpc_2016_1().init();
	}
}