import java.util.Scanner;


public class no9084_1 {
	int d[];
	int p[];
	
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int i = 0 ; i < testcase; i++)
		{
			int num = sc.nextInt();
			p = new int[num+1];
			for (int j = 1; j <= num; j++)
				p[j] = sc.nextInt();
			int price = sc.nextInt();
			d = new int[price+1];
			d[0] = 1;
			System.out.println(dp(num, price));
		}
	}
	int dp(int n, int price)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = p[i]; j <= price; j++)
			{
				d[j] += d[j - p[i]];
			}		
		}
		return d[price];
	}
	public static void main(String[] args) {
		new no9084_1().init();
	}
}
