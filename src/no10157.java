import java.util.Scanner;

public class no10157 {
	private int X, Y;
	private int num;
	private int arr[][];
	void init() {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		num = sc.nextInt();
		arr = new int[Y + 1][X + 1];
		int x = 0, y = 1, turn = 1;
		// X축이랑 Y축이랑 비교해서 작은 수만큼만 돌려준다. 왜? 4*7배열에서는 4번만 방향 회전해주면 달팽이모양 끝나기 때문
		int cnt = X >= Y ? Y : X;
		int cnt_x = X;
		int cnt_y = Y;
		boolean state = false;
		int count = 1;
		while (cnt != 0) {
			for (int i = 1; i <= cnt_x; i++) {
				x += turn;
				state = compare(count);
				if (state) {
					System.out.println(y + " " + x);
					return;
				}
				count++;
			}
			cnt_x--;
			for (int i = 1; i < cnt_y; i++) {
				y += turn;
				state = compare(count);
				if (state) {
					System.out.println(y + " " + x);
					return;
				}
				count++;
			}
			cnt_y--;
			turn *= -1;
			cnt--;
		}
		if (state == false)
			System.out.println(0);
	}

	boolean compare(int count) //
	{
		if (count == num)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		new no10157().init();
	}
}
