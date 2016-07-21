import java.util.Scanner;


public class no2502 {
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		int cookie = sc.nextInt();
		int x = fibo(day-3);
		int y = fibo(day-2);
		for (int i = 0 ; i < cookie; i ++)
		{
			for (int j = 0; j < cookie; j ++)
			{
				if ( (x * i) + (y * j) == cookie )
				{
					System.out.println(i);
					System.out.println(j);
					return ;
				}
			}
		}
	}
	int fibo(int num)
	{
		if (num <= 1) return 1;
		return fibo(num-1) + fibo(num-2);
	}
	public static void main(String[] args) {
		new no2502().init();
	}
}
