import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class no2631 {
	int d[] = new int[201];
	int a[];
	void init()
	{
		FastScanner sc = new FastScanner();
		int num = sc.nextInt();
		a = new int[num+1];
		for (int i = 1; i <= num; i++)
			a[i] = sc.nextInt();
		System.out.println(num - dp(num));
	}
	int dp(int n)
	{
		int max = 1;
		for (int i = 1; i <= n; i++)
		{
			d[i] = 1;
			for (int j = 1; j <= i; j++)
			{
				if (a[i] > a[j] && d[j]+1 > d[i]) d[i] = d[j]+1;
			}
			max = max < d[i] ? d[i] : max;
		}
		return max;
	}
	public static void main(String[] args) {
		new no2631().init();
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
