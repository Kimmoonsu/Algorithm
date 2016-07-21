import java.util.Scanner;


public class no2178_dfs {
	private int x, y;
	private int map[][];
	private boolean visited[][];
	private int cache[][] = new int[100][100];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		map = new int[x][y];
		visited = new boolean[x][y];
		for (int i = 0; i < x; i ++)
			for (int j = 0 ; j < y; j ++)
			{
				map[i][j] = sc.nextInt();
				cache[i][j] = -1;
			}
		int check = func(0,0,0);
		System.out.println(check);
		for (int i = 0 ; i < x; i++)
		{
			for (int j = 0 ; j < y; j++)
				System.out.print(cache[i][j] + " ");
			System.out.println();
		}
			
	}
	int func(int x, int y, int l)
	{
		if (x < 0 || x > this.x-1 || y < 0 || y > this.y-1) return 0;
		if (map[x][y] == 0) return 0;
		if (x == this.x-1 && y == this.y-1) return 1;
		if (cache[x][y] != -1) return cache[x][y];
		System.out.println("x : " + x + " y : " + y);
		cache[x][y] = ( func(x, y+1, l+1) | func(x+1, y, l+1) );
		if (cache[x][y] == 0)
			cache[x][y] = (func(x-1, y,l+1) | func(x, y-1,l+1));
		return l;
	}
	public static void main(String[] args) {
		new no2178_dfs().init();
	}
}
