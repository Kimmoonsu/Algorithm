import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class no12865 {
	int d[][] = new int[101][100001];
	int w_v[][] = new int[101][2];
	void init() throws Exception {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 1; i <= N; i++)
			for (int j = 0; j <= 1; j++)
				w_v[i][j] = sc.nextInt();
		System.out.println(func(N,K));
	}
	int func(int N, int K) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j < w_v[i][0]) d[i][j] = d[i-1][j];
				else d[i][j] = Math.max(d[i-1][j], w_v[i][1] + d[i-1][j-w_v[i][0]]);
			}
		}
		return d[N][K];
	}
	public static void main(String[] args) throws Exception {
		new no12865().init();
	}
	
	static class FastScanner {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int nextInt() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
