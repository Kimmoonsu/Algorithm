import java.util.Scanner;


public class JOI_B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int arr[] = new int[people+1];
		int baton = sc.nextInt();
		for (int i = 1; i <= people; i ++)
			arr[i] = sc.nextInt();
		for (int i = 2 ; i <= baton; i ++)
		{
			for (int j = 1; j < people; j++)
			{
				if (arr[j] % i > arr[j+1] % i)
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}	
			}
		}
		for (int k = 1; k <= people; k++)
			System.out.println(arr[k]);
	}
}
