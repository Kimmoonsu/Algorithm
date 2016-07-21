package ac.kr.DataStructure;

public class DP {
	static int n = 4;
	static int board[][] = { 
			{ 2, 1, 3, 2 }, 
			{ 1, 4, 2, 2 }, 
			{ 1, 4, 1, 2 },
			{ 1, 4, 1, 0 } };
	static int cache[][] = new int[5][5];

	public static int jump(int y, int x) {
		
		System.out.println("x : " + x + " y : " +y);
		if (y >= n || x >= n)
			return 0;
		if (y == n - 1 && x == n - 1)
			return 1;
		
		if (cache[y][x] != -1)
			return cache[y][x];
		
		int jumpSize = board[y][x];
		
		return cache[y][x] = (jump(y + jumpSize, x) | jump(y, x + jumpSize));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				cache[i][j] = -1;
		int check = jump(0, 0);
		if (check == 1)
			System.out.println("성공");
		else if (check == 0)
			System.out.println("실패");
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
				System.out.print(cache[i][j]+ "   ");
			System.out.println();
		}
	}
}
