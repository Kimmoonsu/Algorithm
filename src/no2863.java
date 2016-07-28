import java.util.Scanner;


public class no2863 {
	private int arr[][] = new int[3][3];
	private double max[] = new double[5];
	void init() {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 2; i++)
			for (int j = 1; j <= 2; j++)
				arr[i][j] = sc.nextInt();
		int cnt = 0;
		while (cnt < 4) {
			max(cnt);
			turnArr();
			cnt ++;
		}
		int index = 0;
		for (int i = 1; i < 4; i++) {
			index = max[index] >= max[i] ? index : i;
		}
		System.out.println(index);
	}
	void max(int cnt) {
		max[cnt] = (double)arr[1][1]/arr[2][1] + (double)arr[1][2]/arr[2][2];
	}
	void turnArr() {
		int change_arr[][] = new int[3][3];
		change_arr[1][1] = arr[2][1];
		change_arr[1][2] = arr[1][1];
		change_arr[2][1] = arr[2][2];
		change_arr[2][2] = arr[1][2];
		for (int i = 1; i <= 2; i ++)
			for (int j = 1; j <= 2; j ++)
				arr[i][j] = change_arr[i][j];
	}
	public static void main(String[] args) {
		new no2863().init();
	}
}
