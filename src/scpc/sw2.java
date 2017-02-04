package scpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class sw2 {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	Set<Integer> set = new HashSet<Integer>();
	
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < arr.size() ; i++) System.out.println(arr.get(i));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			sb.append("Case #" + t + "\n");
			int N = Integer.parseInt(br.readLine());
			int cnt[][] = new int[N+1][N+1]; 
			int map2[][] = new int[N+1][N+1];
			int map[][] = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				String input[] = br.readLine().split(" ");
				for (int j = 1; j <= N; j++) map[i][j] = Integer.parseInt(input[j-1]);
			}
			bfs(cnt, N);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map2[i][j] = map[i][j];
				}
			}
			dfs(cnt,map,map2,N,1,1);
			sb.append(func()+"\n");
			set.clear();
		}
		System.out.println(sb);
	}
	void bfs(int cnt[][], int N) {
		for (int i = 1; i<=N; i++) cnt[i][1] = i;
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				cnt[i][j] = cnt[i][j-1]+1;  
			}
		}
	}

	void dfs(int map[][], int num[][], int num2[][], int N, int x, int y) {
		if (x == N && y == N) {
			set.add(num[x][y]);
			return ;
		}
		int dx[] = {0,1};
		int dy[] = {1,0};
		for (int i = 0; i <= 1; i ++) {
			if (x+dx[i] <= N && y+dy[i] <= N) {
				if (map[x+dx[i]][y+dy[i]]-1 == map[x][y]) {
					num[x+dx[i]][y+dy[i]] = num2[x+dx[i]][y+dy[i]] * num[x][y];
					if (num[x+dx[i]][y+dy[i]] >= 6) {						
						int cnt = func(num[x+dx[i]][y+dy[i]]);
						if (cnt == 0) return;
					}
					dfs(map, num, num2, N, x+dx[i], y+dy[i]);
				}
			}
		}	
	}
	int func() {
		int max = 0;
		for (int i = 0; i < set.size(); i++) {
			StringBuilder sb = new StringBuilder();
			int num = set.iterator().next();
			while (num >= 6) {
				sb.append(String.valueOf(num%6));
				num /= 6;
			}
			sb.append(String.valueOf(num));
			sb.reverse();
			int cnt = countFunc(sb.toString());
			max = max > cnt ? max : cnt;
		}
		return max;
	}
	int func(int number) {
		StringBuilder sb = new StringBuilder();
//		int num = set.iterator().next();
		while (number >= 6) {
			sb.append(String.valueOf(number%6));
			number /= 6;
		}
		sb.append(String.valueOf(number));
		sb.reverse();
		int cnt = countFunc(sb.toString());
	
		return cnt;
	}
	int countFunc(String input) {
		int cnt = 0;
		for (int i = input.length()-1; i >=0; i--) {
			if (input.charAt(i)-48 == 0) cnt ++;
			else break;
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		new sw2().init();
	}
}
