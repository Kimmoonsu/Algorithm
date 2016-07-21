import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
public class no2178 {
	int queue_X[], queue_Y[],queue_L[];
	private int x, y;
	private int map[][];
	
	private int rear = 0, front= 0;
	private boolean visited[][];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		map = new int[x][y];
		queue_X = new int[x*y];
		queue_Y = new int[x*y];
		queue_L = new int[x*y];
		visited = new boolean[x][y];
		for (int i = 0; i < x; i ++)
			for (int j = 0 ; j < y; j ++)
				map[i][j] = sc.nextInt();
		System.out.println(func());
	}
	
	void L_enQueue(int queue[], int data)
	{
		queue[this.rear] = data ;
		
	}
	int L_deQueue(int queue[])
	{
		int val = queue[front];
		
		return val;
	}
	
	void X_enQueue(int queue[], int data)
	{
		queue[this.rear] = data;
		
	}
	int X_deQueue(int queue[])
	{
		int val = queue[front];
		
		return val;
	}
	void Y_enQueue(int queue[], int data)
	{
		queue[this.rear] = data;
		this.rear++;
	}
	int Y_deQueue(int queue[])
	{
		int val = queue[front++];
		return val;
	}
	int func()
	{
		int x= 0 , y = 0, l=0;
		int cnt = 1;
		X_enQueue(queue_X, x);
		L_enQueue(queue_L,queue_L[front]+1);
		Y_enQueue(queue_Y, y);
		// 
		while (x != this.x-1 || y != this.y-1){
			
			System.out.println();
			l = L_deQueue(queue_L);
			x = X_deQueue(queue_X);
			y = Y_deQueue(queue_Y);
			
			System.out.println("x : " + x + " y : " + y);
			// 동쪽 검사
			if (y < this.y-1 && visited[x][y+1]==false && map[x][y+1] == 1)
			{
				System.out.println("동쪽" + (y+1));
				X_enQueue(queue_X, x);
				L_enQueue(queue_L, l+1);
				Y_enQueue(queue_Y, y+1);
				visited[x][y+1] = true;	
			}
			// 남쪽 검사
			if (x < this.x-1 && visited[x+1][y]==false && map[x+1][y] == 1)
			{
				System.out.println("남쪽");
				X_enQueue(queue_X, x+1);
				L_enQueue(queue_L, l+1);
				Y_enQueue(queue_Y, y);
				visited[x+1][y] = true;
			}
			// 서쪽 검사
			if (y > 0 && visited[x][y-1]==false && map[x][y-1] == 1)
			{
				System.out.println("서쪽");
				X_enQueue(queue_X, x);
				L_enQueue(queue_L, l+1);
				Y_enQueue(queue_Y, y-1);
				visited[x][y-1] = true;
			}
			// 북쪽 검사
			if (x > 0 && visited[x-1][y]==false && map[x-1][y] == 1)
			{
				System.out.println("북쪽");
				X_enQueue(queue_X, x-1);
				L_enQueue(queue_L, l+1);
				Y_enQueue(queue_Y, y);
				visited[x-1][y] = true;
			}
			
		}
		return queue_L[front-1];
	}
	public static void main(String[] args) {
		new no2178().init();
	}
}
