import java.util.Scanner;


public class no10156 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cookie_price = sc.nextInt();
		cookie_price *= sc.nextInt(); // ��Ű �ϳ��� ���� * ��Ű ����
		cookie_price = sc.nextInt() - cookie_price;// ������ ���� ������ ��Ű�� �� ������ ����.
		cookie_price = cookie_price < 0 ? cookie_price*-1 : 0;
		System.out.println(cookie_price);
	}
}
