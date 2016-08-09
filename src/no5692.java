import java.util.Scanner;


public class no5692 {
	int fact[] = new int[6];
	void init()
	{
		factorial();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int total = 0;
			String N = sc.nextLine();
			if (Integer.parseInt(N) == 0) return;
			for (int i = 0; i < N.length(); i++)
				total += ((int)N.charAt(i)-48)*fact[N.length()-i];
			System.out.println(total);
		}
	}
	void factorial()
	{
		for (int i = 1; i <= 5; i ++)
		{
			fact[i] = 1;
			for (int j = i; j >= 1; j--)
				fact[i] *= j;
		}
	}
	public static void main(String[] args) {
		new no5692().init();
	}
}
