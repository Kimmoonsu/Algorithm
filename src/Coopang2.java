import java.util.Scanner;

public class Coopang2 {

	public static int solution(int[] coinTypes, int money) {
		int d[] = new int[10001];
		d[0] = 1;
		for (int i = 1; i <= coinTypes.length-1; i++) {
			for (int j = coinTypes[i-1]; j <= money; j++) {
				d[j] += d[j - coinTypes[i-1]];
			}
		}
		return d[money];
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coinTypes = {1, 2};
		int money = 1000;
		System.out.println(solution(coinTypes, money));
	}
}
