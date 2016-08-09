import java.util.Arrays;
import java.util.Scanner;


public class JOI_A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[4];
		int arr2[] = new int[2];
		for (int i = 0 ; i < 4; i ++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		for (int i = 0 ; i < 2; i ++)
			arr2[i] = sc.nextInt();
		Arrays.sort(arr2);
		int sum = arr2[1] ;
		
		for (int i = 1 ; i < 4; i++)
			sum += arr[i];
		System.out.println(sum);
	}
}
