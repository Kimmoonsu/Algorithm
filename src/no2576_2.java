import java.util.Scanner;


public class no2576_2 {
	public static void main(String[] args) {
		int data[] = new int[7];
		Scanner sc = new Scanner(System.in);
		for (int i = 0 ; i < 7; i++)
			data[i] = sc.nextInt();
		int sum = 0;
		int temp = 0;
		for (int i = 0 ; i < 7; i++)
		{
			if (data[i] % 2 != 0)
			{
				if (temp == 0)
					temp = data[i];
				else
					temp = temp < data[i] ? temp : data[i];
				sum += data[i];				
			}
		}
		if (sum == 0)
			System.out.println("-1");
		else
		{
			System.out.println(sum);
			System.out.println(temp);
		}
	}
}
