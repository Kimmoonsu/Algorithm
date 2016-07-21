import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 
public class no3055 {
    private int map[][] = new int[100][100];
    boolean visited[][];
    private int X, Y;
    private int water_cnt = 1;
    void init()
    {
        Scanner sc = new Scanner(System.in);
        int start_x = 0, start_y = 0;
        X = sc.nextInt();
        Y = sc.nextInt();
        sc.nextLine();
        
        visited = new boolean[X+1][Y+1];
        for (int i = 1 ; i <= X; i ++)
        {
            String str = sc.nextLine();
            for (int j = 1 ; j <= Y; j++)
            {
            	if (str.charAt(j-1) == 'D')  {
            		map[i][j] = -1;
            	}
            	else if (str.charAt(j-1) == '.') map[i][j] = 0;
            	else if (str.charAt(j-1) == '*') map[i][j] = -2;
            	else if (str.charAt(j-1) == 'X') map[i][j] = -3;
            	else if (str.charAt(j-1) == 'S') {
            		start_x = i;
            		start_y = j;
            		map[i][j] = 1;
            	}
                visited[i][j] = false;
            }
        }
        int value = func(start_x, start_y);
        System.out.println(value == -1 ? "KAKTUS" : value);
    }
    void increaseWater()
    {
    	int water[][] = new int[100][100];
    	for (int i = 1; i <= X; i++) {
    		for (int j = 1; j <= Y; j++) {
    			water[i][j] = map[i][j];
    		}
    	}
    	for (int i = 1; i <= X; i++) {
    		for (int j = 1; j <= Y; j++) {
    			if (water[i][j] == -2) {
    				map[i+1][j] = map[i+1][j] == 0 ? -2 : map[i+1][j];
    				map[i-1][j] = map[i-1][j] == 0 ? -2 : map[i-1][j];
    				map[i][j+1] = map[i][j+1] == 0 ? -2 : map[i][j+1];
    				map[i][j-1] = map[i][j-1] == 0 ? -2 : map[i][j-1];
    			}
    		}
    	}
    }
    int func(int start_x, int start_y)
    {
        Queue<Integer> x_queue = new LinkedList<Integer>();
        Queue<Integer> y_queue = new LinkedList<Integer>();
         
        int x = start_x, y = start_y;
        if (map[x][y] == 1)
        {
            x_queue.offer(x);
            y_queue.offer(y);
        }   
         
        int x_state[] = {1,0,-1,0};
        int y_state[] = {0,1,0,-1};
 
        while (!x_queue.isEmpty())
        {
            x = x_queue.poll();
            y = y_queue.poll();
            visited[x][y] = true;
            if (map[x][y] == water_cnt) {
            	increaseWater();
            	water_cnt++;
            }
            for (int i = 0 ; i < 4; i ++)
            {
            	if (map[x + x_state[i]][y + y_state[i]] == -1) {
            		map[(x + x_state[i])][(y + y_state[i])] = map[x][y]+1;
            		return map[x][y];
            	}
            		
                if ((x + x_state[i])<= X && (y + y_state[i]) <= Y && (x + x_state[i]) >0 && (y + y_state[i]) > 0 && visited[x + x_state[i]][y + y_state[i]]==false && map[x + x_state[i]][y + y_state[i]] == 0)
                {
                    x_queue.offer((x + x_state[i]));
                    y_queue.offer((y + y_state[i]));
                    map[(x + x_state[i])][(y + y_state[i])] = map[x][y]+1;
                }
                 
            }	
        }
        return -1;
        
    }
    public static void main(String[] args) {
        new no3055().init();
    }
}