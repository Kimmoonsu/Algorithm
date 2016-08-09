import java.util.Scanner;


public class no2501 {
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int q = sc.nextInt();
		System.out.println(func(p,q));
	}
	int func(int p, int q)
	{
		int sum = 0;
		for (int i = 1 ; i <= p; i++)
		{
			sum = (p % i == 0) ? (sum+1) : sum;
			if (sum == q)
				return i;
		}
		return 0;
	}
	public static void main(String[] args) {
		new no2501().init();
	}
}
