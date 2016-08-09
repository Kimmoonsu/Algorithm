import java.util.Scanner;

public class no2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		int index = 1;
		for (int i = 1; i < 9; i++) {
			int num = sc.nextInt();
			if (temp < num)
			{
				temp = num;
				index = i+1;
			}
		}
		System.out.println(temp);
		System.out.println(index);
	}
}
