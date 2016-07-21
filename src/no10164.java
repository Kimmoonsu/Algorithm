import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class no10164 {
	int d[][] = new int[16][16];
	void init()
	{
		FastScanner sc = new FastScanner();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k_x = 1, k_y = 1;
		int k = sc.nextInt();
		int cnt = 1;
		for (int i = 1; i <= x; i ++)
		{
			for (int j = 1; j <= y; j++)
			{
				if (cnt == k) {
					k_x = i;
					k_y = j;
				}
				cnt ++;
			}
		}
		System.out.println(dp(x, y, k_x, k_y));
	}
	int dp(int x, int y, int k_x, int k_y)
	{
		d[1][1] = 1;
		for (int i = 1; i <= k_x; i++)
		{
			for (int j = 1; j <= k_y; j++)
			{
				if (i == 1 && j == 1) continue;
				else d[i][j] = d[i-1][j] + d[i][j-1];
			}
		}
		
		for (int i = k_x; i <= x; i++)
		{
			for (int j = k_y; j <= y; j++)
			{
				if (i == 1 && j == 1) continue;
				else d[i][j] = d[i-1][j] + d[i][j-1];
			}
		}
		
		return d[x][y];
	}
	public static void main(String[] args) {
		new no10164().init();
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
