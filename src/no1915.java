import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;




public class no1915 {
	int d[][] = new int[1001][1001];
	int a[][];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.nextLine();
		a = new int[x+1][y+1];
		for (int i = 1; i <= x; i++)
		{
			String str = sc.nextLine();
			for (int k = 0; k < str.length(); k++)
				a[i][k+1] = (int)str.charAt(k) - 48;
		}
		
		for (int i = 1; i<= y; i++) if(a[0][i] == 1) d[0][i] = 1;
		for (int i = 1; i<= x; i++) if(a[i][0] == 1) d[i][0] = 1;
		System.out.println(dp(x,y));
	}
	int dp(int x, int y)
	{
		int max = 0;
		for (int i = 1; i <= x; i++)
		{
			for (int j = 1; j <= y; j++)
			{
				if (a[i][j] == 1) {
					d[i][j] = Math.min(Math.min(d[i-1][j], d[i][j-1]), d[i-1][j-1]) + 1;
					max = max < d[i][j] ? d[i][j] : max;
				}
			}
		}
		
		return max*max;
	}
	public static void main(String[] args) {
		new no1915().init();
	}
}	
