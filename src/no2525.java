import java.util.Scanner;


public class no2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt() * 60;
		for (int i = 0 ; i < 2; i ++)
			time += sc.nextInt();
		
		if (time/60 >= 24)
			System.out.println(time/60 - 24 +" " + time%60);
		else
			System.out.println((time / 60) + " " + (time%60));
	}
}
