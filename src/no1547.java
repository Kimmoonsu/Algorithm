import java.util.Scanner;


public class no1547 {
	int arr[] = {0,1,0,0};
	void init() {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		while (M != 0) {
			swap(sc.nextInt(), sc.nextInt());
			M--;
		}
		for (int i = 1; i <= 3; i++)
			if (arr[i] == 1) System.out.println(i);
	}
	void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args) {
		new no1547().init();
	}
}
