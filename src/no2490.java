import java.util.Scanner;


public class no2490 {
	public static void main(String[] args) {
		char state_arr[] = {'D', 'C', 'B', 'A', 'E'};
		Scanner sc = new Scanner(System.in);
		for (int i = 0 ; i < 3; i ++)
		{
			int sum = 0;
			for (int j = 0; j < 4; j ++)
				sum += sc.nextInt();
			System.out.println("" + state_arr[sum]);
		}
	}
}
