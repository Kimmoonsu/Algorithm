import java.util.Scanner;


public class no7567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int temp = str.charAt(0);
		int sum = 10;
		for (int i = 1; i < str.length(); i++)
		{
			if (temp == str.charAt(i))
			{
				sum += 5;
			}
			else 
			{
				temp = str.charAt(i);
				sum += 10;
			}
		}
		System.out.println(sum);
	}
}
