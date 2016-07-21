package scpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1 {
	int d[];
	int a[];
	void init()
	{
		FastScanner sc = new FastScanner();
		int testcase = sc.nextInt();
		for (int t = 0; t < testcase; t++)
		{
			int num = sc.nextInt();
			a = new int[num+1];
			d = new int[1000001];
			for (int i = 1; i <= num; i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(dp(num, k));
		}
	}
	int dp(int n, int k)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= k; j++)
			{
				if (i >= j)
					d[i] = d[i] > (d[i - a[j]] + 1 ) ? d[i-a[j]] + 1 : d[i];
			}
			for (int j = 1; j <= n; j++)
				System.out.print(d[j] + " ");
			System.out.println();
		}
		return d[n];
	}
	public static void main(String[] args) {
		new no1().init();
	}
	class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
	  
	    public FastScanner() {
	        br = new BufferedReader(new InputStreamReader(System.in));
	    }
	  
	    String nextToken() {
	        while (st == null || !st.hasMoreElements()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return st.nextToken();
	    }
	  
	    int nextInt() {
	        return Integer.parseInt(nextToken());
	    }
	  
	    long nextLong() {
	        return Long.parseLong(nextToken());
	    }
	  
	    double nextDouble() {
	        return Double.parseDouble(nextToken());
	    }
	  
	    String nextLine() {
	        String str = "";
	        try {
	            str = br.readLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return str;
	    }
	}
}
