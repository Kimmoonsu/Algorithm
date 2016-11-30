import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class no11576 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N+1];
		String str[] = br.readLine().split(" ");
		for (int i = 1; i <= str.length; i++) {
			num[i] = Integer.parseInt(str[i-1]);
		}
		System.out.println(func(num, A, B));
	}
	StringBuilder func(int num[], int A, int B) {
		int total = 0;
		int cnt = 1;
		for (int i = num.length-1; i > 0; i--) {
			total += num[i] * cnt;
			cnt *= A;
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (total >= B) {
			arr.add(total%B);
			total /= B;
		}
		arr.add(total);
		StringBuilder sb = new StringBuilder();
		for (int i = arr.size()-1; i >= 0; i--) sb.append(arr.get(i) +" ");
		sb.append("\n");
		return sb;
	}
	public static void main(String[] args) throws IOException {
		new no11576().init();
	}
}
