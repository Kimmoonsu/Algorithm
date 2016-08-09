import java.util.Scanner;


public class no2588 {
	private int num1, num2;
	private int arr[];
	public no2588()
	{
		
	}
	void init()
	{
		Scanner sc = new Scanner(System.in);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
	}
	void multiply()
	{
		int size = String.valueOf(num1).length() >= String.valueOf(num2).length() ? String.valueOf(num1).length() : String.valueOf(num2).length();
		arr = new int[size];
		int index = size-1;
		for (int i = 0 ; i < size; i++)
		{
			arr[i] = num1 * (String.valueOf(num2).charAt(index)-48);
			index--;
			System.out.println(arr[i]);
		}
		int sum = 0;
		
		for (int i = 0; i < size; i++)
		{
			int multi_cnt = 1;
			if (i != 0)
			{
				for (int j = 0; j < i; j++)
				{
					multi_cnt *= 10;
				}
				sum += arr[i] * multi_cnt;
			}
			else
				sum += arr[i];
		}
		System.out.println(sum);
		
		
	}
	public static void main(String[] args) {
		no2588 m = new no2588();
		m.init();
		m.multiply();
	}
}
