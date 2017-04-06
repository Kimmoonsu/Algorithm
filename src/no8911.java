import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no8911 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			String str = br.readLine();
			int x = 0, y = 0;
			int dir = 1;
			int max_x = 0, min_x = 0, max_y = 0, min_y = 0;
			sb.append(move(str,x,y,dir,max_x,min_x,max_y,min_y)+"\n");	
		}
		System.out.println(sb);
		br.close();
	}
	int move(String str, int x, int y, int dir, int max_x, int min_x, int max_y, int min_y) {
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		for (int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case 'F' :
				x += dx[dir];
				y += dy[dir];
				max_x = max_x > x ? max_x : x;
				max_y = max_y > y ? max_y : y;
				min_x = min_x < x ? min_x : x;
				min_y = min_y < y ? min_y : y;	
				break;
			case 'B' :
				x -= dx[dir];
				y -= dy[dir];
				max_x = max_x > x ? max_x : x;
				max_y = max_y > y ? max_y : y;
				min_x = min_x < x ? min_x : x;
				min_y = min_y < y ? min_y : y;				
				break;
			case 'L' :
				dir = changeDir(dir, 1);
				break;
			case 'R' :
				dir = changeDir(dir, 2);
				break;
			}
//			System.out.println(x +", " + y +" : " + dir + " str : " + str.charAt(i));
		}
//		System.out.println(max_x+"-"+min_x + " , " + max_y + " - " + min_y);
		return (Math.abs(max_x-min_x)) * (Math.abs(max_y - min_y));
	}
	int changeDir(int dir, int state) {
		if (state == 1) {// L 
			switch (dir) {
			case 0 : return 2;
			case 1 : return 3;
			case 2 : return 1;
			case 3 : return 0;
			}
		} else if (state == 2) {
			switch(dir) {
			case 0 : return 3;
			case 1 : return 2;
			case 2 : return 0;
			case 3 : return 1;
			}
		}
		return dir;
	}
	public static void main(String[] args) throws IOException {
		new no8911().init();
	}
}
