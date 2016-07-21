import java.util.Scanner;


public class JOI_C {
	int map[][];
	int sum = 1000000000;
	int X;
	int Y;
	void init()
	{
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		map = new int[X][Y];
		sc.nextLine();
		for (int i = 0; i < X; i ++)
		{
			String str = sc.nextLine();
			for (int j = 0 ; j < Y; j ++)
			{
				if (str.charAt(j) =='W')
				{
					map[i][j] = 0;
				}
				else if (str.charAt(j) == 'B')
					map[i][j] = 1;
				else if (str.charAt(j) == 'R')
					map[i][j] = 2;	
			}
		}	
//		for (int i = 0 ; i < X; i ++)
//		{
//			for (int j = 0 ; j <Y; j ++)
//				System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
		int cnt = func(0, 0, 0, 0);
		System.out.println(sum);
	}
	int func(int x, int cnt, int state, int check)
	{
		//System.out.println("x : " + x + " cnt : " + cnt + " state : " + state + " check "  + check);
		if (x == X) {
			if (check > 2)
			{
				sum = sum > cnt ? cnt : sum;
				//System.out.println("sum : " + sum);
			}
			/*
4 4
WBRW
WBRW
WBRR
RWBW
			 */
			return 0;
		}
		for (int i = 0; i < Y; i ++)
		{
			if (map[x][i] != state)
			{
				cnt++;
				//System.out.println("Áõ°¡");
			}
		}
		if (state == 0)
		{
			return func(x+1, cnt, 0, check) | func(x+1, cnt, 1, check+1); 
		}
		else if (state == 1)
		{
			if (x == (X-2))
				return func(x+1, cnt, 2, check+1);
			else
				return func(x+1, cnt, 1, check+1) | func(x+1, cnt, 2, check+1); 
		}
		else if (state == 2)
		{
			return func(x+1, cnt, 2, check+1); 
		}
		return cnt;
	}
	public static void main(String[] args) {
		new JOI_C().init();
	}
}
