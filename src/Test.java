import java.util.*;
import java.io.*;
import java.math.*;
 
public class Test{
    static BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = 
            new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int h, w, K, len, ans = 0;
    static char[][] map;
    static char[] str;
    static int[][][] dp;
    
    public static void main(String args[]) throws IOException{
        // Scanner sc = new Scanner(System.in);
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	h = Integer.parseInt(st.nextToken());
    	w = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	map = new char[h][w];
    	for(int i = 0; i < h; i++) map[i] = br.readLine().toCharArray();
    	str = br.readLine().toCharArray();
    	len = str.length;
    	dp = new int[h][w][len];
    	for(int i = 0; i < h; i++)
    		for(int j = 0; j < w; j++) Arrays.fill(dp[i][j], -1);
    	for(int i = 0; i < h; i++){
    		for(int j = 0; j < w; j++){
    			if(map[i][j] == str[0]) ans += sol(i, j, 0);
    		}
    	}
    	bw.write(ans+"");
        bw.close();
    }
    
    static int sol(int y, int x, int l){
    	if(dp[y][x][l] == -1){
    		if(l == len-1) return dp[y][x][l] = 1;
    		dp[y][x][l] = 0;
    		for(int i = Math.max(y-K, 0); i <= Math.min(y+K, h-1); i++){
    			if(i == y) continue;
    			if(map[i][x] == str[l+1]) dp[y][x][l] += sol(i, x, l+1);
    		}
    		for(int i = Math.max(x-K, 0); i <= Math.min(x+K, w-1); i++){
    			if(i == x) continue;
    			if(map[y][i] == str[l+1]) dp[y][x][l] += sol(y, i, l+1);
    		}
    	}
    	return dp[y][x][l];
    }
}