import java.util.ArrayList;
import java.util.Scanner;


public class no2605_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> people = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			people.add(i-sc.nextInt(), (i+1));	
		}
		for (int i = 0; i < N; i++)
			System.out.print(people.get(i)+ " ");
	}
}
