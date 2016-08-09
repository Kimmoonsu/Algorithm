import java.util.Scanner;


public class no2576 {
	private int data[] = new int[7];
	public no2576(){}
	void init()
	{
		Scanner sc = new Scanner(System.in);
		for (int i = 0 ; i < 7; i++)
			data[i] = sc.nextInt();
	}
	void func()
	{
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
	public static void main(String[] args) {
		no2576 m = new no2576();
		m.init();
		m.func();
	}
}
