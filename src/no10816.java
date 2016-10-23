import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class no10816 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String N_input[] = br.readLine().split(" ");
		int M = Integer.parseInt(br.readLine());
		String M_input[] = br.readLine().split(" ");
		System.out.println(func(N, N_input, M, M_input));
	}
	String func(int N, String[] N_input, int M, String[] M_input) {
		HashMap<Integer, Integer> number_list = new HashMap<Integer, Integer>();
		for (int i = 0 ; i < N; i++) {
			int num = Integer.parseInt(N_input[i]);
			if (number_list.containsKey(num)) {
				number_list.put(num, number_list.get(num)+1);
			} else number_list.put(num, 1);
		}
		StringBuilder sb = new StringBuilder();
		int total = 0;
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(M_input[i]);
			if (number_list.containsKey(num)) sb.append(number_list.get(num) + " ");
			else sb.append("0 ");
		}
		sb.append("\n");
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		new no10816().init();
	}
}
