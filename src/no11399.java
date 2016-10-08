import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;


public class no11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = st.countTokens();
		int arr[] = new int[cnt]; 
		for (int i = 0 ; i < cnt; i++) arr[i] = Integer.parseInt(st.nextToken(" "));
		Arrays.sort(arr);
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j ++)
				result += arr[j]; 
		}
		System.out.println(result);
	}
}
