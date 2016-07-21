import java.util.Scanner;


public class no9095_1 {
	int d[];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++)
		{
			d = new int[12];
			int N = sc.nextInt();
			System.out.println(dp(N));
		}
	}
	int dp(int N)
	{
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i <= N; i++)
		{
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		return d[N];
	}
	public static void main(String[] args) {
		new no9095_1().init();
	}
}
