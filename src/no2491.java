import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class no2491 {
	int arr[] = new int[100001];
	int min_d[] = new int[100001];
	int max_d[] = new int[100001];
	void init() {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
		System.out.println(dp(N));
	}
	int dp(int N) {
		int max = 1;
		int min = 1;
		min_d[1] = 1;
		max_d[1] = 1;
		for (int i = 2; i <= N; i++) {
			min_d[i] = 1;
			max_d[i] = 1;
			if (arr[i] >= arr[i-1] && max_d[i] < max_d[i-1]+1) max_d[i] = max_d[i-1]+1;
			if (arr[i] <= arr[i-1] && min_d[i] < min_d[i-1]+1) min_d[i] = min_d[i-1]+1;
			max = max > max_d[i] ? max : max_d[i];
			min = min > min_d[i] ? min : min_d[i];
		}
		return max > min ? max : min;
	}
	
	public static void main(String[] args) {
		new no2491().init();
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
