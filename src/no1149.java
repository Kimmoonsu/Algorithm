import java.util.Arrays;
import java.util.Scanner;


public class no1149 {
	int d[][];
	
	int h[][];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		d = new int[num+1][4];
		h = new int[num+1][4];
		for (int i = 1; i <= num; i++)
			for (int j = 1; j <= 3; j ++)
				h[i][j] = sc.nextInt();
		d[1][1] = h[1][1];
		d[1][2] = h[2][2];
		d[1][3] = h[3][3];
		System.out.println(dp(num));
	}
	int min(int a, int b, int c)
	{
		int temp = a < b ? a : b;
		temp = temp < c ? temp : c;
		return temp;
	}
	int dp(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			d[i][1] = Math.min(d[i-1][2], d[i-1][3]) + h[i][1];
			d[i][2] = Math.min(d[i-1][1], d[i-1][3]) + h[i][2];
			d[i][3] = Math.min(d[i-1][1], d[i-1][2]) + h[i][3];
		}
		
		return min(d[n][1], d[n][2], d[n][3]);
	}
	public static void main(String[] args) {
		new no1149().init();
	}
}
