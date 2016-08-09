import java.util.Arrays;
import java.util.Scanner;


public class no2476 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int max = 0;
		for (int i = 0 ; i < testcase; i++)
		{
			int arr[] = new int[3];
			int temp = 0;
			for (int j = 0; j < 3; j ++)
				arr[j] = sc.nextInt();
			Arrays.sort(arr);
			if (arr[0] == arr[1] && arr[0] == arr[2])
				temp = 10000+(arr[0]*1000);
			else if (arr[0] == arr[1] || arr[1] == arr[2] )
				temp = 1000 + (arr[1] * 100);
			else
				temp = arr[2] * 100;
			if (max <= temp)
				max = temp;
		}
		System.out.println(max);
	}
}
