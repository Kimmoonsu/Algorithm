import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class no2605_2 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		String input[] = br.readLine().split(" ");
		int num[] = new int[N+1];
		for (int i = 1 ; i <= N; i++) {
			num[i] = Integer.parseInt(input[i-1]); 
		}
		System.out.println(func(arr, num));
	
	}
	StringBuilder func(ArrayList<Integer> arr, int[] num) {
		StringBuilder sb = new StringBuilder();
		arr.add(0);
		for (int i = 1; i <= num.length-1; i++) {
			arr.add(i-num[i], i);
		}
		for (int i = 1; i <= num.length-1; i++) sb.append(arr.get(i) + " ");
		sb.append("\n");
		return sb;
	}
	public static void main(String[] args) throws IOException {
		new no2605_2().init();
	}
}