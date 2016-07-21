import java.util.Scanner;


public class no2563 {
	private int size;
	private int arr[][] = new int[101][101];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		for (int i = 0; i < size; i ++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = y; j < y+10; j++)
			{
				for (int k = x; k < x+10; k++)
				{
					arr[j][k] += 1;
				}
			}
		}
		System.out.println(size*100 - sum());
	}
	int sum()
	{
		int sum = 0;
		for (int i = 1; i <= 100; i ++)
		{
			for (int j = 1; j <= 100; j ++)
				if (arr[i][j] != 0 && arr[i][j] != 1)
					sum ++;
		}
		return sum;
	}
	public static void main(String[] args) {
		new no2563().init();
	}
}
