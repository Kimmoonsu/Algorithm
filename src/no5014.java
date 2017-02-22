import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no5014 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int max = Integer.parseInt(input[0]);
		int start = Integer.parseInt(input[1]);
		int target = Integer.parseInt(input[2]);
		int up = Integer.parseInt(input[3]);
		int down = Integer.parseInt(input[4]);
		int check[] = new int[max + 1 + max + 1];
		int result = elevator(max, start, target, up, down, check);
		System.out.println(result == -1 ? "use the stairs" : result);
	}
	int elevator(int max, int start, int target, int up, int down, int check[]) {
		int count = 0;
		int current_floar = start;
		check[current_floar] = 1;
		while (current_floar != target) {
			int move_up = current_floar + up;
			int move_down = current_floar - down;
			if (current_floar > target) {
				if (check[move_down] == 0 && move_down >= 1) {
					check[move_down] = 1;
					current_floar = move_down;
					count ++;
				} else if (check[move_up] == 0 && move_up <= max) {					
					check[move_up] = 1;
					current_floar = move_up;
					count++;
				} else {
					return -1;
				}
			} else if (current_floar < target) {
				// 위부터 
				if (check[move_up] == 0 && move_up <= max) {					
					check[move_up] = 1;
					current_floar = move_up;
					count++;
				} else if (check[move_down] == 0 && move_down >= 1) {
					check[move_down] = 1;
					current_floar = move_down;
					count ++;
				} else {
					return -1;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		new no5014().init();
	}
}
