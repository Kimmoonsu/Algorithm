import java.util.Scanner;


public class no2344 {
	int arr[][] = new int[1001][1001];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		for (int i = 1; i <= X; i++)
			for (int j = 1; j <= Y; j++)
				arr[i][j] = sc.nextInt();
		for (int i = 1; i <= X; i++)
			System.out.print(func(i,1,X,Y,2)+ " ");
		for (int i = X+1; i <= X+Y; i++)
			System.out.print(func(X,i-X, X, Y, 1) + " ");
		for (int i = X+Y+1; i <= (2*X) + Y; i++)
			System.out.print(func(X-(i-(X+Y))+1,Y, X, Y, 3) + " ");
		for (int i = (2*X) + Y + 1; i <= (2*X) + (2*Y); i++)
			System.out.print(func(1, ((2*X)+(2*Y)-i+1), X, Y, 0) + " ");
	}
	int func(int row, int col, int X, int Y, int dir)
	{
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		while (row > 0 && row <= X && col > 0 && col <= Y)
		{
			dir = changedir(dir, arr[row][col]);
			row += dx[dir];
			col += dy[dir];
		}
		if (row == 0) return (2*X) + (2*Y) - col + 1;
		else if (row == X+1) return row + col - 1;
		else if (col == 0) return row;
		else return (2*X) + (2*Y) - col - row + 2; 
	}
	int changedir(int dir, int mirror)
	{
		if (mirror == 1) return 3-dir;
		else return dir;
	}
	public static void main(String[] args) {
		new no2344().init();
	}
}
