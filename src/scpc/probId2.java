package scpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class probId2 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			sb.append("Case #"+t +"\n");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			sb.append(func(arr,N) + "\n");
		}
		System.out.println(sb.toString());
	}
	int func(int[] arr, int N) {
		
		int n = N;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			int num = arr[i]+n--;
			max = max < num ? num : max;
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			count = arr[i] + N >= max ? count + 1 : count;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		new probId2().init();
	}
}
