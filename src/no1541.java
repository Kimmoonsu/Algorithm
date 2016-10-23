import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class no1541 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Vector<Integer> sign = new Vector<Integer>();
		Vector<Integer> num = new Vector<Integer>();
		String input_num = "";
		sign.add(1);
		for (int i = 0 ; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-') {
				if (input_num != "") num.add(Integer.parseInt(input_num));
				input_num = "";
				if (c == '+') {
					sign.add(1);
				}else sign.add(-1);
			} else {
				input_num += c;
			}
		}
		num.add(Integer.parseInt(input_num));
		System.out.println(greedy(sign, num));
	}
	int greedy(Vector<Integer> sign, Vector<Integer> num) {
		boolean minus = false;
		int result = 0;
		for (int i = 0; i < num.size(); i++) {
			if (sign.get(i) == -1) minus = true;
			if (minus) result -= num.get(i);
			else result += num.get(i);
		}
		return result;
	}
	public static void main(String[] args) throws IOException  {
		new no1541().init();
	}
}
