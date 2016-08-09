import java.util.Scanner;


public class no12866 {
	public static void main(String[] args) {
		long c[] = new long[100];
		Scanner sc = new Scanner(System.in);
		int L = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			c[(int)str.charAt(i)] += 1;
		}
		c[65] *= c[(int)'C'];
		c[65] %= 1000000007;
		c[65] *= c[(int)'G'];
		c[65] %= 1000000007;
		c[65] *= c[(int)'T'];
		c[65] %= 1000000007;
		System.out.println(c[65]);
	}
}
