import java.util.Scanner;

public class no2456 {
	int arr[][] = new int[4][4];
	int total[] = new int[4];

	void init() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 3; j++) {
				int num = sc.nextInt();
				arr[j][num] += 1;
			}
		}
		int index = total();
		index = compare(index);
		System.out.println(index == -1 ? 0 + " " + total[1] : index + " "
				+ total[index]);
	}

	int total() {
		int max = 0;
		int index = 0;
		for (int i = 1; i <= 3; i++) {
			total[i] = arr[i][1] + (arr[i][2] * 2) + (arr[i][3] * 3);
			if (max < total[i]) {
				index = i;
				max = total[i];
			}
		}
		return index;
	}

	int compare(int index) {
		boolean state = false;
		if ((total[1] == total[2]) && (total[1] == total[3])) {
			for (int i = 1; i <= 3; i++) {
				if (index != i && total[index] == total[i]) {
					if ((arr[index][2] == arr[i][2])
							&& (arr[index][3] == arr[i][3]))
						state = true;
					else {
						if (arr[index][3] < arr[i][3]) {
							index = i;
							state = false;
						}
						else if (arr[index][3] == arr[i][3]) {
							if (arr[index][2] < arr[i][2]) {
								index = i;
								state = false;
							}
						}
					}
				}
			}
			if (state)
				return -1;
		} else {
			for (int i = 1; i <= 3; i++) {
				if (index != i && total[index] == total[i]) {
					if ((arr[index][2] == arr[i][2])
							&& (arr[index][3] == arr[i][3]))
						return -1;
					else {
						index = arr[index][3] < arr[i][3] ? i : index;
						if (arr[index][3] == arr[i][3]) {
							index = arr[index][2] < arr[i][2] ? i : index;
						}
					}
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		new no2456().init();
	}
}
