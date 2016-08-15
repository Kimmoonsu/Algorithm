import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class no2980 {
	private int now_position = 0;
	private int time = 0;
	private Hashtable<Integer, ArrayList<Integer>> h = new Hashtable<Integer, ArrayList<Integer>>();
	void init() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt(); //L meter
		
		for (int i = 1; i <= N; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			int position = sc.nextInt();
			a.add(sc.nextInt());
			a.add(sc.nextInt());			
			h.put(position, a);
		}
		System.out.println(func(L));
	}
	int func(int L) {
		while (now_position != L) {
			now_position++;
			time ++;
			if (h.containsKey(now_position)) {
				int red = h.get(now_position).get(0);
				int green = h.get(now_position).get(1);
				int state = time % (red+green); 
				if ( state <= red ) time += red - state; 
			}
		}
		return time;
	}
	public static void main(String[] args) {
		new no2980().init();
	}
}
