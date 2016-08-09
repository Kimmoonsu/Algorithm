import java.util.Scanner;


public class no2745 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String B = sc.next();
		int N = Integer.parseInt(sc.next());
		
		int total = 0;
		for (int i = 0; i < B.length(); i++)
		{
			int sum = 1;
			for (int j = i; j < B.length()-1; j++)
				sum *= N;
			char n = B.charAt(i);
			if (n >= 'A')
				sum = ((int)n - 55) * sum;
			else
				sum = ((int)n-48) * sum;
			total += sum;
		}
		System.out.println(total);
	}
}
