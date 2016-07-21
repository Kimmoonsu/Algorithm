import java.util.Scanner;


public class no1309 {
	int d[][] = new int[100001][3];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(dp(num));
	}
	int dp(int n)
	{
		d[1][0] = 1;
		d[1][1] = 1;
		d[1][2] = 1;
		for (int i = 2; i <= n; i++)
		{
			d[i][0] = (d[i-1][1] + d[i-1][2] + d[i-1][0]) % 9901;
			d[i][1] = (d[i-1][2] + d[i-1][0]) % 9901;
			d[i][2] = (d[i-1][1] + d[i-1][0] ) % 9901;
		}
		return (d[n][0] + d[n][1] + d[n][2]) % 9901;
	}
	public static void main(String[] args) {
		new no1309().init();
	}
}
