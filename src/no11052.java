import java.util.Scanner;

public class no11052 {
	int d[];
	int p[];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		d = new int[num+1];
		p = new int[num+1];
		for (int i = 1; i <= num; i ++)
			p[i] = sc.nextInt();
		System.out.println(dp(num));
	}
	int dp(int n)
	{
		for (int i = 1; i <= n; i ++)
		{
			int temp = 0;
			for (int j = 1; j <= i; j ++)
			{
				if (temp < p[j] + d[i-j])
				{
					d[i] = p[j] + d[i-j];
					temp = p[j] + d[i-j];
				}
			}
		}
		return d[n];
	}
	public static void main(String[] args) {
		new no11052().init();
	}
}
