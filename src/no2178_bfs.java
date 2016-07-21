import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 
public class no2178_bfs {
    private int map[][];
    boolean visited[][];
    private int X, Y;
    void init()
    {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();
        sc.nextLine();
        map = new int[X][Y];
        visited = new boolean[X][Y];
        for (int i = 0 ; i < X; i ++)
        {
            String str = sc.nextLine();
            for (int j = 0 ; j < Y; j++)
            {
                map[i][j] = str.charAt(j)-48;
                visited[i][j] = false;
            }
        }
        func();
    }
    void func()
    {
        Queue<Integer> x_queue = new LinkedList<Integer>();
        Queue<Integer> y_queue = new LinkedList<Integer>();
         
        int x = 0, y = 0;
        if (map[0][0] == 1)
        {
            x_queue.offer(0);
            y_queue.offer(0);
        }   
         
        int x_state[] = {1,0,-1,0};
        int y_state[] = {0,1,0,-1};
 
        while (x!=(X-1) || y!=(Y-1))
        {
            x = x_queue.poll();
            y = y_queue.poll();
            visited[x][y] = true;
            for (int i = 0 ; i < 4; i ++)
            {
 
                if ((x + x_state[i])< X && (y + y_state[i]) < Y && (x + x_state[i]) >=0 && (y + y_state[i]) >= 0 && visited[x + x_state[i]][y + y_state[i]]==false && map[x + x_state[i]][y + y_state[i]] == 1)
                {
                    x_queue.offer((x + x_state[i]));
                    y_queue.offer((y + y_state[i]));
                    map[(x + x_state[i])][(y + y_state[i])] = map[x][y]+1;
                }
                 
            }
 
        }
        System.out.println(map[X-1][Y-1]);
    }
    public static void main(String[] args) {
        new no2178_bfs().init();
    }
}