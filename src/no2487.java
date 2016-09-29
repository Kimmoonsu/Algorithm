import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class no2487 {
	void init () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		ArrayList<Integer> solution = new ArrayList<Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			a.add(Integer.parseInt(str[i]));
			solution.add(i+1);
		}
		System.out.println(func(solution, a));
	}
	int func(ArrayList<Integer> solution, ArrayList<Integer> a) {
		int count = 0;
		ArrayList<Integer> s = new ArrayList<Integer>();
		s.addAll(solution);
		do {
			ArrayList<Integer> b = new ArrayList<Integer>();
			for (int i = 0; i < solution.size(); i++) {
				b.add(solution.get(a.get(i)-1));
			}
			solution.clear();
			solution.addAll(b);
			count ++;
		}	while (!s.equals(solution));
		return count;
	}
	public static void main(String[] args) throws IOException {
		new no2487().init();
	}
}
