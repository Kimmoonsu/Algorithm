import java.util.Scanner;


public class no10156 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cookie_price = sc.nextInt();
		cookie_price *= sc.nextInt(); // 쿠키 하나의 가격 * 쿠키 개수
		cookie_price = sc.nextInt() - cookie_price;// 동수가 가진 돈에서 쿠키의 총 가격을 뺀다.
		cookie_price = cookie_price < 0 ? cookie_price*-1 : 0;
		System.out.println(cookie_price);
	}
}
