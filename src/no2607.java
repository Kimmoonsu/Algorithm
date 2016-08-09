import java.util.Scanner;


public class no2607 {
	int str_arr[];
	int input_arr[];
	void init() {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		int cnt = 0;
		str_arr = new int[91];
		for (int i = 0; i < str.length(); i++) str_arr[(int)str.charAt(i)] += 1;
		for (int i = 0 ; i < N-1; i++) {
			input_arr = new int[91];
			String input_str = sc.nextLine();
			for (int j = 0; j < input_str.length(); j++) input_arr[(int)input_str.charAt(j)] += 1;
			int state = func(str, input_str);
			cnt = state == 1 ? cnt + 1 : cnt;
		}
		System.out.println(cnt);
	}
	int func(String str, String input_str) {
		int arr[] = new int[91];
		for (int i = 65; i <= 90; i++) arr[i] = str_arr[i];
		boolean original_state = true;
		boolean input_state = true;
		if (Math.abs(str.length() - input_str.length()) >= 2) return -1;
		for (int i = 0 ; i < str.length(); i++) {
			int index = (int)str.charAt(i);
			int original_num = arr[index];
			int input_num = input_arr[index];
			arr[index] = 0;
			input_arr[index] = 0;
			if (original_state == false && input_state == false && Math.abs(original_num-input_num) == 1) return -1;
			else if (original_num - input_num == 1) {
				if (original_state == false) return -1;
				else original_state = false;
			}
			else if(input_num - original_num == 1) {
				if( input_state == false) return -1;
				else input_state = false;
			}
			else if (Math.abs(original_num - input_num) > 1) return -1;
		}
		int cnt = 0;
		for (int i = 65; i <= 90; i++) {
			cnt += input_arr[i];
		}
		if (cnt > 1) return -1;
		else if (input_state == false && cnt == 1) return -1;
		if (cnt == 1 &&input_state == false && str.length() < input_str.length()) return -1;
		return 1;
	}
	public static void main(String[] args) {
		new no2607().init();
	}
}
/*
2
ABCDEFGHIJ
BDCFGHIJAA
*/