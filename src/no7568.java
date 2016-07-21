import java.util.Scanner;


public class no7568 {
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int people[][] = new int[size][size];
		for (int i = 0 ; i < size; i ++)
		{
			for (int j = 0; j < 2; j ++)
				people[i][j] = sc.nextInt();
		}
		int rank[] = new int[size];
		rankFunc(people, rank, size);
	}
	void rankFunc(int people[][], int rank[], int size)
	{
		for (int i = 0 ; i < size; i ++)
		{
			int cnt = 0;
			for (int j = 0; j < size; j ++)
			{
				if (j != i && (people[i][0] < people[j][0]) && (people[i][1] < people[j][1]))
					cnt++;
			}
			rank[i] = cnt+1;
		}
		for (int i = 0 ; i < size; i ++)
			System.out.print(rank[i]+ " ");
		System.out.println();
	}
	public static void main(String[] args) {
		new no7568().init();
	}
}
