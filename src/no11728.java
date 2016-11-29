import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class no11728 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int A_arr[] = new int[N+1];
		int B_arr[] = new int[M+1];
		String str[] = br.readLine().split(" ");
		for (int i = 0 ; i < str.length; i++) A_arr[i+1] = Integer.parseInt(str[i]);
		String str2[] = br.readLine().split(" ");
		for (int i = 0 ; i < str2.length; i++) B_arr[i+1] = Integer.parseInt(str2[i]);
		 
		System.out.println(solve(A_arr, B_arr, N, M));
	}
	String solve(int A_arr[], int B_arr[], int N, int M) {
		int i = 1;
		int j = 1;
		int arr[] = new int[N+M+1];
		for (int cnt = 1; cnt <= N+M; cnt++) {
			if (i <= N && j <= M) {
				arr[cnt] = A_arr[i] >= B_arr[j] ? B_arr[j++] : A_arr[i++];
			} else if (i > N) arr[cnt] = B_arr[j++];
			else arr[cnt] = A_arr[i++];
		}
		StringBuilder sb = new StringBuilder();
		for (int cnt = 1; cnt < arr.length; cnt++) sb.append(arr[cnt] +" ");
		sb.append("\n");
		return sb.toString();
	}
//	String merge(int A_arr[], int B_arr[], int N, int M) {
//		int i = 1;
//		int j = 1;
//		int k = 1;
//		int result_arr[] = new int[N+M+1];
//		while (i <= N || j <= M) {
//			if (j > M || (i <= N && (A_arr[i] <= B_arr[j]))){
//				result_arr[k++] = A_arr[i++];				
//			}else {
//				result_arr[k++] = B_arr[j++];
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		for (int cnt = 1; cnt < result_arr.length; cnt++) sb.append(result_arr[cnt] + " ");
//		sb.append("\n");
//		return sb.toString();
//	}
	public static void main(String[] args) throws IOException {
		new no11728().init();
	}
}
