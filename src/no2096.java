import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class no2096 {
	BigInteger d[][];
	int map[][];
	void init()
	{
		FastScanner sc = new FastScanner();
		int num = sc.nextInt();
		d = new BigInteger[num+2][5];
		for (int i = 0; i <= num+1; i++)
			for (int j = 0; j <= 4; j++)
				d[i][j] = new BigInteger("0");
		map = new int[num+2][5];
		for (int i = 1; i <= num; i++)
			for (int j = 1; j <= 3; j++)
				map[i][j] = sc.nextInt();
		System.out.println(maxDP(num) + " " + minDP(num));	
	}
	
	// 최대
	BigInteger maxFunc(int n)
	{
		BigInteger temp = new BigInteger("0");
		for (int i = 1; i <=3; i++)
		{
			if (d[n][i].compareTo(temp) == 1)
				temp = d[n][i];
		}
		return temp;
	}
	BigInteger max(BigInteger a, BigInteger b, BigInteger c)
	{
		if (a.compareTo(b) == 1) {
			if (a.compareTo(c) == 1) return a;
			else return c;
		}
		else {
			if (b.compareTo(c) == 1) return b;
			else return c;
		}
	}
	// 최소
	BigInteger minFunc(int n)
	{
		BigInteger temp = d[n][1];
		for (int i = 2; i <= 3; i++)
		{
			if (temp.compareTo(d[n][i]) == 1)
				temp = d[n][i];
		}
		return temp;
	}
	BigInteger min(BigInteger a, BigInteger b, BigInteger c)
	{
		if (a.compareTo(b) == 1) {
			if (b.compareTo(c) == 1) return c;
			else return b;
		}
		else {
			if (a.compareTo(c) == 1) return c;
			else return a;
		}
	}
	BigInteger maxDP(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= 3; j++)
			{
				d[i][j] = max(d[i-1][j-1], d[i-1][j], d[i-1][j+1]).add(new BigInteger(""+map[i][j]));
			}
		}
		return maxFunc(n);
	}
	BigInteger minDP(int n)
	{
		d = new BigInteger[n+2][5];
		for (int i = 0; i <= n+1; i++)
			for (int j = 0; j <= 4; j++)
				d[i][j] = new BigInteger("1000000");
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= 3; j++)
				d[i][j] = new BigInteger("0");
		for (int i = 1; i <= 3; i++)
			d[1][i] = new BigInteger(""+map[1][i]);
		for (int i = 2; i <= n; i++)
		{
			for (int j = 1; j <= 3; j++)
			{
				d[i][j] = min(d[i-1][j-1], d[i-1][j], d[i-1][j+1]).add(new BigInteger(""+map[i][j]));
			}
		}
		return minFunc(n);
	}
	public static void main(String[] args) {
		new no2096().init();
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
