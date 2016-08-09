import java.util.Scanner;


public class scpc_2 {
	int arr[][];
	boolean visited[][];
	void init() 
	{
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= testcase; t++)
		{
			arr = new int[1001][1001];
			visited = new boolean[1001][1001];
			int N = Integer.parseInt(sc.nextLine());
			for (int i = 1; i <= N; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < str.length(); j++)
					arr[i][j+1] = str.charAt(j)-48;
			}	
			System.out.println("Case #" + t);
			System.out.println(func(1,1,2,N));
		}
	}
	int func(int row, int col, int dir, int N)
	{
		int dx[] = {1, - 1, 0, 0};
		int dy[] = {0, 0, 1, -1};
		int count = 0;
		while (row <= N && row > 0 && col > 0 && col <= N) {
			count = visited[row][col] == false && arr[row][col] != 0 ? count+1 : count;
			visited[row][col] = true;
			dir = changedir(dir, arr[row][col]);
			row += dx[dir];
			col += dy[dir];
		}
		return count;
	}
	int changedir(int dir, int mirror)
	{
		if (mirror == 1) return 3-dir;
		else if (mirror == 2) return (dir+2)%4;
		else return dir;
	}
	public static void main(String[] args) {
		new scpc_2().init();
	}
}
