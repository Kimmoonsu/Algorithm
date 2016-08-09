import java.util.Scanner;

public class factorial {
	private int num;
	private int cache[] = new int[100000000];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		for (int i = 0 ; i < cache.length; i++)
			cache[i] = -1;
		System.out.println(fibo(num));
	}
	int fibo(int num)
	{

		if (num == 1|| num == 2) return 1;
		if (cache[num] != -1) return cache[num];
		
		return cache[num] = fibo(num-1) + fibo(num-2);
	}
	int func(int num)
	{
		if (num == 0) return 1;
		return num * func(num-1);
	}
	public static void main(String[] args) {
		new factorial().init();
	}
}
