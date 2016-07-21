import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class no11726 {
	BigInteger d[];
	void init()
	{
		FastScanner sc = new FastScanner();
		int num;
		num = sc.nextInt();
		  
		d = new BigInteger[num+1];
		d[0] = new BigInteger("1");
		d[1] = new BigInteger("1");
		System.out.println(dp(num));
	}
	BigInteger dp(int n)
	{
		for (int i = 2; i <= n; i++)
		{
			d[i] = d[i-1].add(d[i-2]);
		}
		return d[n].mod(new BigInteger("10007"));
	}
	public static void main(String[] args) {
		new no11726().init();
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
