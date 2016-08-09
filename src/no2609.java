import java.util.Scanner;


public class no2609 {
	void init () {
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int min = sc.nextInt();
		if (max < min) {
			int temp = max;
			max = min;
			min = temp;
		}
		int gcd_num = gcd(max,min);
		System.out.println(gcd_num + " " + (max*min)/gcd_num);
	}
	int gcd(int max, int min)
	{
		while (min!=0) {
			int temp = max;
			max = min;
			min = temp%min;
		}
		return max;
	}
	public static void main(String[] args) {
		new no2609().init();
	}
}
