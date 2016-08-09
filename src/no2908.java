import java.util.Scanner;

public class no2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		for (int i = 1; i <= 2; i ++)
		{
			StringBuffer sb = new StringBuffer();
			sb.append(sc.next());
			int reverse_number = Integer.parseInt(sb.reverse().toString());
			num = reverse_number > num ? reverse_number : num;
		}
		System.out.println(num);
	}
}
