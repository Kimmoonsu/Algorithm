import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no10809 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int alpha_arr[] = new int[26];
		for (int i = 0 ; i < alpha_arr.length; i++) alpha_arr[i] = -1;
		func(alpha_arr, input);
	}
 	void func(int alpha_arr[], String input) {
		for (int i = 0 ; i < input.length(); i++) {
			int index = (int)input.charAt(i)-97;
			alpha_arr[index] = alpha_arr[index] == -1 ? i : alpha_arr[index];
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0 ; i < alpha_arr.length; i++) sb.append(""+alpha_arr[i] + " ");
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		new no10809().init();
	}
}
