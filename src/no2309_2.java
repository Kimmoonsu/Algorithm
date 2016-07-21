
import java.util.Scanner;

public class no2309_2 {
	private int arr[] = new int[9];

	private int find_array[] = new int[7];

	public no2309_2() {
	}

	void init() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++)
			arr[i] = sc.nextInt();
	}

	// 버블 정렬
	void sort() {
		for (int i = 8; i >= 0; i--) {
			for (int j = 0; j < i; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		}
	}


	void find() {
		int sum = 0;
		int num1, num2;
		for (int i = 0; i < 9; i++)
			sum += arr[i];
		sum = sum - 100;
		
		for (int i = 0; i < 9; i++) {
			num1 = arr[i];
			for (int j = i + 1; j < 9; j++) {
				num2 = arr[j];
				if (num1 + num2 == sum) 
				{

					int index = 0;
					for (int k = 0; k < 9; k++) {
						
						if (k != i && k != j) {
							find_array[index] = arr[k];
							index++;
						}
					}
					break;
				}
			}
		}
		for (int i = 0; i < 7; i++)
			System.out.println(find_array[i]);
	}

	public static void main(String[] args) {
		no2309_2 m = new no2309_2();
		m.init();
		m.sort();
		m.find();
	}
}
