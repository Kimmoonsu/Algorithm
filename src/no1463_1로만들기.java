import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class no1463_1로만들기 {
	private int num;
	private int d[] = new int[10000001];
	public void init()
	{
		FastScanner sc = new FastScanner();
		num = sc.nextInt();
		System.out.println(""+dp(num));
	}
	
	public int dp(int n)
	{
		d[1] = 0;
		for (int i = 2; i <= n; i++)
		{
			d[i] = d[i-1] +1;
			if (i % 2 == 0 && d[i] > d[i/2] + 1)
				d[i] = d[i/2] + 1;
			if (i % 3 == 0 && d[i] > d[i/3] + 1)
				d[i] = d[i/3] + 1;
		}
		return d[n];
	}
	
	public static void main(String[] args) {
		new no1463_1로만들기().init();
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
