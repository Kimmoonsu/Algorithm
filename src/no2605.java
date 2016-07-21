import java.util.ArrayList;
import java.util.Scanner;

public class no2605 {
	private int size;
	private int people_arr[];
	private int cnt_arr[];
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public no2605() {

	}

	void init() {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		people_arr = new int[size];
		cnt_arr = new int[size];
		for (int i = 0; i < size; i++) {
			cnt_arr[i] = sc.nextInt();
		}
		
	}
	
	//ArrayList를 사용한 방법
	void func1()
	{
		for (int i = 0 ; i < size; i ++)
		{
			arrayList.add((i-cnt_arr[i]), i+1);
		}
		for (int i = 0; i < size; i++)
			System.out.print(arrayList.get(i) + " ");
	}
	
	//배열을 사용한 방법
	void func2() {
		for (int i = 0; i < size; i++) {

			int arr[] = new int[cnt_arr[i]];
			int count = 0;
			for (int j = i - cnt_arr[i]; j < i; j++) {
				arr[count] = people_arr[j];
				count++;
			}
			people_arr[i - cnt_arr[i]] = i + 1;
			count = 0;
			for (int j = i - cnt_arr[i] + 1; j <= i; j++) {
				people_arr[j] = arr[count];
				count++;
			}
		}
		for (int j = 0; j < size; j++)
			System.out.print(people_arr[j] + " ");

	}
	
	public static void main(String[] args) {
		no2605 m = new no2605();
		m.init();
		m.func1();
		//m.func2();
		
	}
}
