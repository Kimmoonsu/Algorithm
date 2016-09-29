import java.util.*;
public class no2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < N; i++)
			a.add(sc.nextInt());
		Collections.sort(a);
		for (int x : a)
			System.out.println(x);
	}
}
