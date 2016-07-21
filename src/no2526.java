import java.util.Scanner;


public class no2526 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = 1; // arr ªÁ¿Ã¡Ó
		int arr[] = new int[100];
		int N = sc.nextInt();
		arr[0] = N;
		int P = sc.nextInt();
		for (int i = 0; ; i++)
		{
			int temp = arr[i] * N % P;
			for (int j = 0; j < length; j++)
			{
				if (temp == arr[j])
				{
					System.out.println((length-j));
					return;
				}
			}
			arr[length] = temp;
			length++;
		}
	}
}
