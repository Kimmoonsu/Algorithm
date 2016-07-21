import java.util.Scanner;


public class no1003 {
	int d[][];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++)
		{
			int N = sc.nextInt();
			d = new int[41][2];
			dp(N);
		}
	}
	void dp(int n) {
		d[0][0] = 1;
		d[1][1] = 1;
	    for (int i = 2; i <= n; i++)
	    {
	    	d[i][0] = d[i-1][0] + d[i-2][0];
	    	d[i][1] = d[i-1][1] + d[i-2][1];
	    }
	    System.out.println(d[n][0] + " " + d[n][1]);
	}
	public static void main(String[] args) {
		new no1003().init();
	}
}
