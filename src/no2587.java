
import java.util.Arrays;
import java.util.Scanner;


public class no2587 {
	private int arr[];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		arr = new int[5];
		int sum = 0;
		for (int i = 0 ; i < 5; i ++)
		{
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		System.out.println(sum/5);
		System.out.println(arr[2]);
	}
	public static void main(String[] args) {
		new no2587().init();
	}
}
