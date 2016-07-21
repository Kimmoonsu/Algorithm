import java.util.Scanner;


public class no2302 {
	int d[] = new int[41];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fibo();
		int m[] = new int[sc.nextInt()+2];
		int max = 1;
		for (int i = 1; i < m.length-1; i++)
		{
			m[i] = sc.nextInt();
		}
		m[m.length-1] = n+1;
		for (int i = 1; i < m.length; i++)
		{
			max *= d[m[i] - m[i-1] -1];
		}
		System.out.println(max);
	}
	
	void fibo()
	{
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i <= 40; i++)
		{
			d[i] = d[i-1] + d[i-2];
		}
	}
	public static void main(String[] args) {
		new no2302().init();
	}
}
