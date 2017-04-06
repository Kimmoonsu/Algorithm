import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no11723 {
	StringBuilder sb = new StringBuilder();
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int bit = 0;
		final int MAX = (int)Math.pow(2, 21) -1;
		for (int i = 1; i <= M; i++) {
			String str[] = br.readLine().split(" ");
			int num = 0;
			if (!str[0].equals("all") && !str[0].equals("empty"))
				num = Integer.parseInt(str[1]);
			switch (str[0]) {
			case "add":
				bit = add(bit, num);
				break;
			case "remove":
				bit = remove(bit, num);
				break;
			case "toggle":
				bit = toggle(bit, num);
				break;
			case "all":
				bit = MAX;
				break;
			case "empty":
				bit = 0;
				break;
			case "check":
				sb.append(check(bit, num)+"\n");
				break;
			}
		}
		br.close();
		System.out.println(sb);
	}

	int check(int bit, int num) {
		int state = bit & (1 << num);
		return state == 0 ? 0 : 1;
	}

	int add(int bit, int num) {
		bit = bit | (1 << num);
		return bit;
	}

	int remove(int bit, int num) {
		bit = bit & ~(1 << num);
		return bit;
	}

	int toggle(int bit, int num) {
		bit = bit ^ (1 << num);
		return bit;
	}

	int all(int bit) {
		for (int i = 1; i <= 20; i++) {
			bit = toggle(bit, i);
		}
		return bit;
	}
	int empty(int bit) {
		for (int i = 1; i <= 20; i++) {
			bit = remove(bit, i);
		}
		return bit;
	}

	public static void main(String[] args) throws IOException {
		new no11723().init();
	}
}
