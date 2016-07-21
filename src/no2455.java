import java.util.Scanner;


public class no2455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		num -= sc.nextInt();
		num += sc.nextInt();
		for (int i = 1 ; i < 4; i ++)
		{
			int count = num;
			count -= sc.nextInt();
			count += sc.nextInt();
			if (count >= num)
				num = count;
		}
		System.out.println(num);
	}
}
