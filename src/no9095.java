import java.util.Scanner;


public class no9095 {
	private int d[];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int i = 0 ; i < testcase; i ++)
		{
			int num = sc.nextInt();
			d = new int[num+1];
			d[0] = 1;
			d[1] = 1;
			if (num < 2)
			{
				System.out.println(d[num]);
			}
			else
				System.out.println(dp(num));	
		}
	}
	int dp(int n)
	{
		d[2] = 2;
		if (n == 2)
			return d[2];
		for (int i = 3; i <= n; i++)
		{
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		return d[n];
	}
	public static void main(String[] args) {
		new no9095().init();
	}
}
