import java.util.Scanner;


public class no10158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int ant_x = sc.nextInt();
		int ant_y = sc.nextInt();
		int time = sc.nextInt();
		int direction[] = {1,1};
		for (int i = 0 ; i < time; i ++)
		{
			if (ant_x >= X || ant_x <= 0) direction[0] *= -1;
			if (ant_y >= Y || ant_y <= 0) direction[1] *= -1;
			ant_x += direction[0];
			ant_y += direction[1];
		}
		System.out.println(ant_x + " " + ant_y);
		
		/******************다른 사람이 짠 소스 ***************/
//		  final Scanner sc = new Scanner(System.in);
//	        final long w = sc.nextInt();
//	        final long h = sc.nextInt();
//	        final long p = sc.nextInt();
//	        final long q = sc.nextInt();
//	        final long t = sc.nextInt();
//	        sc.close();
//	 
//	        long x = (p + t) % (2*w);
//	        if(x > w) x = 2*w - x;
//	        long y = (q + t) % (2*h);
//	        if(y > h) y = 2*h - y;
//	        System.out.println(x + " " + y);
	   /**********************************************/
	}
}
