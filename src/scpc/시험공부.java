package scpc;

import java.util.Arrays;
import java.util.Scanner;

public class 시험공부 {
	void init(){
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			sb.append("Case #" + t + "\n");
			int N = sc.nextInt();
			int K = sc.nextInt();
			int arr[] = new int[N];				
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			sb.append(max(arr, N, K) + "\n");
		}
		System.out.println(sb);
	}
	int max(int arr[], int N, int K) {
		Arrays.sort(arr);
		int total = 0;
		for (int i = N-1; i >= N-K; i--) {
			total += arr[i];
		}
		return total;
	}
	public static void main(String[] args){
		new 시험공부().init();
	}
}
