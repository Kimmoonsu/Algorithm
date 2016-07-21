import java.util.Scanner;

//아직 못품
public class no2590 {
	public static void main(String[] args) {
		int sum = 0;
		int arr[] = new int[6];
		Scanner sc = new Scanner(System.in);
		for (int i = 0 ; i < 6; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		int count;
		count = arr[5];
		
		
		boolean state = true;
		
		while(state)
		{
			if (arr[4] > 0)
			{
				arr[4] -= 1;
				arr[0] -= 11;
				count ++;
			}
			if (arr[3] > 0)
			{
				count ++;
				arr[3] -= 1;
				arr[1] -= 5;
				if (arr[1] < 0)
				{
					arr[0] -= (arr[1] * (-4));
					arr[1] = 0;
				}			
			}
			if (arr[2] > 0)
			{
				count ++;
				arr[2] -= 4;
				if (arr[2] < 0)
				{
					if (arr[1] > 0)
					{
						arr[1]-=1;
						arr[0] -= 5;
					}
				}
			}
		}
		System.out.println(count);
	}
}
