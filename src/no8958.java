import java.util.Scanner;


public class no8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= testcase; i++)
		{
			int sum = 0;
			int cnt = 0;
			String answer = sc.nextLine();
			for (int j = 0; j < answer.length(); j++) {
				if (answer.charAt(j) =='O') cnt++;
				else cnt = 0;
				sum += cnt;
			}
			System.out.println(sum);
		}
	}
}
