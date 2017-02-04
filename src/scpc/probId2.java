package scpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class probId2 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			sb.append("Case #"+t +"\n");
			int N = Integer.parseInt(br.readLine());
			int count_arr[] = new int[2000001];
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(br.readLine());
				arr.add(num);
				count_arr[num] += 1;
			}
			Collections.sort(arr);
			sb.append(func(N, arr, count_arr)+"\n");
		}
		System.out.println(sb);
	}
	int func(int N, ArrayList<Integer> arr, int[] count_arr) {
		int index = 0;
		while (index < N) {
			int max = arr.get(index) + N;
			int n = 1;
			boolean state = true; // 성공 
			int i = N-1;
			while(i > index) {
				int num = arr.get(i);
				int minus = count_arr[num] - 1;
				n += minus;
				num += n;
				i = i - minus -1;
				n++;
				if (max < num) {
					state = false; // 실패  
					break;
				}
			}
			
			if (state) return N-index;
			index++;
		}
		return N-index;
		
	}
	
	public static void main(String[] args) throws IOException {
		new probId2().init();
	}
}
