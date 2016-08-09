import java.util.Scanner;


public class no10797 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		int count = 0;
		for (int i = 0 ; i < 5; i ++)
		{
			int num = sc.nextInt();
			if (day == num)
				count ++;
		}
		System.out.println(count);
	}
}
