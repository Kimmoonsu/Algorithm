import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class no1517 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		int arr[] = new int[N+1];
		for (int i = 1; i <= input.length; i++) arr[i] = Integer.parseInt(input[i-1]);
		System.out.println(solve(arr, 1, N));
	}
	long solve(int arr[], int start, int end) {
		if (start == end) return 0;
		int mid = (start+end)/2;
		int b[] = new int[end-start+2];
		long total = solve(arr, start, mid) + solve(arr, mid+1, end);
		
		int i = start;
		int j = mid+1;
		int k = 1;
		while (i <= mid || j <= end) {
			if (j <= end && (i > mid || arr[i] >= arr[j])) {
				total += mid-i+1;
				b[k++] = arr[j++];
			} else {
				b[k++] = arr[i++];
			}
		}
		for (int index = start; index <= end; index++) arr[index] = b[index-start+1];
		
		return total;
	}
//	public static long solve(int[] a, int start, int end) {
//        if (start == end) {
//            return 0;
//        }
//        int mid = (start+end)/2;
//        int[] b = new int[end-start+1];
//        long ans = solve(a, start, mid) + solve(a, mid+1, end);
//        for (int i = 0 ; i < a.length; i++) System.out.print(a[i] + " ");
//        System.out.println();
//        {
//            int i = start;
//            int j = mid+1;
//            int k = 0;
//            while (i <= mid || j <= end) {
//                if (i <= mid && (j > end || a[i] <= a[j])) {
//                    b[k++] = a[i++];
//                } else {
//                    ans += (long)(mid-i+1);
//                    b[k++] = a[j++];
//                }
//            }
//        }
//        for (int i=start; i<=end; i++) {
//            a[i] = b[i-start];
//        }
//        return ans;
//    }
	public static void main(String[] args) throws IOException {
		new no1517().init();
	}
}
