import java.util.Scanner;


public class no1476 {
	void init() {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		System.out.println(findDate(E, S, M));
	}
	int findDate(int E, int S, int M) {
		int year = 1, e = 1, s = 1, m = 1;
		while (E != e || S != s || M != m) {
			e++;
			s++;
			m++;
			e = e > 15 ? 1 : e;
			s = s > 28 ? 1 : s;
			m = m > 19 ? 1 : m;
			year++;
		}
		return year;
	}
	public static void main(String[] args) {
		new no1476().init();
	}
}
