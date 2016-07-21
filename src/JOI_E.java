import java.util.ArrayList;
import java.util.Scanner;


public class JOI_E {
	int cache[];
	int vill, road;
	int map[][];
	int map_price[];
	int sum = 1000000;
	void init()
	{
		Scanner sc = new Scanner(System.in);
		vill = sc.nextInt();
		road = sc.nextInt();
		map = new int[road][2];
		cache = new int[road+1];
		for (int i = 1 ; i <= road ; i ++)
		{
			cache[i] = -1;
		}
		map_price = new int[vill+1];
		
		int poison[] = new int[sc.nextInt()]; // 감염 마을
		int poison_road = sc.nextInt();// 감염 마을로부터 인근 마을 횟수
		int price[] = new int[2];
		
		for (int i = 0 ; i < 2; i ++)
		{
			price[i] = sc.nextInt();
		}
		for (int i = 1; i < vill; i++)
			map_price[i] = price[0];
		map_price[1] = 0;
		for (int i = 0 ; i < poison.length; i ++)
		{
			poison[i] = sc.nextInt();
			map_price[poison[i]] = price[1];
		}
//		for (int i = 1 ; i < map_price.length; i++)
//			System.out.print(map_price[i] + " ");
//		System.out.println();
		for (int i = 0 ; i < road; i ++)
		{
			for (int j = 0 ; j < 2; j ++)
			{
				map[i][j] = sc.nextInt();
				//System.out.print(map[i][j] + " ");
			}
		}
		func(poison_road, poison, price);
//		for (int i = 0 ; i < road; i ++)
//		{
//			for (int j = 0 ; j < 2; j ++)
//			{
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		for (int i = 1 ; i < map_price.length; i++)
//			System.out.print(map_price[i] + " ");
//		System.out.println();
		route(1, 0, 0, vill);
		System.out.println(sum);
	}
	
	// 가격 셋팅
	void func(int poison_road, int poison[], int price[])
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int k = 0 ; k < poison.length; k++) // 감염 마을 개수 만큼
		{
			//for (int i = 0; i < poison_road; i++) // 감염 마을의 인근 마을 개수 만큼
			{
				for (int j = 0 ; j < road; j ++) // 마을 개수 만큼
				{
					if (map[j][0] == poison[k])
					{
						map_price[map[j][1]] = price[1];
						arr.add(map[j][1]);
					}
					else if (map[j][1] == poison[k])
					{
						map_price[map[j][0]] = price[1];
						arr.add(map[j][0]);
					}						
				}
				if (poison_road > 1)
				{
					for (int i = 1; i < poison_road; i++) // 감염 마을의 인근 마을 개수 만큼
					{
						ArrayList<Integer> arr2 = new ArrayList<Integer>();
						arr2.addAll(arr);	
						for (int a = 0 ; a < arr2.size(); a ++)
						{
							
							for (int b = 0 ; b < road; b ++) // 마을 개수 만큼
							{
								if (map[b][0] == arr2.get(a))
								{
									map_price[map[b][1]] = price[1];
									arr.add(map[b][1]);
								}
								else if (map[b][1] == arr2.get(a))
								{
									map_price[map[b][0]] = price[1];
									arr.add(map[b][0]);
								}	
							}
						}
						arr.clear();
					}
						
				}
				
				arr.clear();
			}	
		}
	}
	
	int route(int num, int x, int price, int vill)
	{
		
		System.out.println("num : " + num + " x : " + x + " price : " + price + " vill : " + vill);
		if (x == road)
			return 0;
		if (num == vill )
		{
			sum = sum > price ? price : sum;
		//	System.out.println("sum  : " + sum);
			return 0;
		}
		//System.out.println( " map : " + map[x][0]);
		if (map[x][0] == num)
		{
			price += map_price[num];
			//System.out.println("price : " + price + " cache : " + cache[num]);
			if (cache[num] != -1 && cache[num] < price)
			{
				return route(map[x][0], x+1, price-map_price[map[x][0]], vill);
			}
			else
				cache[num] = price;
			num = map[x][1];
			return route(num, 0, price, vill) | route(map[x][0], x+1, price-map_price[map[x][0]], vill);
		}
		else
			return route(num, x+1, price, vill);
		
		
	}
	
	public static void main(String[] args) {
		new JOI_E().init();
	}
}
