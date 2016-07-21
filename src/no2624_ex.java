import java.util.Scanner;


public class no2624_ex {
	private int price;
	private int size;
	private int cache[][];
	private int coin[];
	private int coin_cnt[];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		price = sc.nextInt();
		size = sc.nextInt();
		coin = new int[size];
		coin_cnt = new int[size];
		cache = new int[size+1][price+1];
		for (int i = 0 ; i < size; i++)
		{
			coin[i] = sc.nextInt();
			coin_cnt[i] = sc.nextInt();
		}
		for (int i = 0 ; i <= size; i ++)
			for (int j = 0 ; j <= price; j++)
				cache[i][j] = -1;
		System.out.println(dp(size-1, price));
	}
	
	int dp(int index, int money)
	{
		if (index == -1)
		{
			if (money == 0)
				return 1;
			else return 0;
		}
		if (cache[index][money] != -1) return cache[index][money];
		cache[index][money] = 0;
		for (int i = 0; i <= coin_cnt[index]; i++)
		{
			if(money-(coin[index]*i) < 0) break;
			cache[index][money] += dp(index-1, money - coin[index]*i);
		}
		return cache[index][money];
	}
	public static void main(String[] args) {
		new no2624_ex().init();
	}
}
