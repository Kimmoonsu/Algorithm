//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//
//public class no2618 {
//	void init() throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int W = Integer.parseInt(br.readLine());
//		int W_arr[][] = new int[W+1][3];
//		int d[] = new int[W+1];
//		int car1_x = 1, car1_y = 1, car2_x = N, car2_y = N;
//		
//		d[W] = Integer.MAX_VALUE;
//		for (int i = 1; i <= W; i++) {
//			String input[] = br.readLine().split(" ");
//			W_arr[i][1] = Integer.parseInt(input[0]);
//			W_arr[i][2] = Integer.parseInt(input[1]);
//		}
//	}
//	int func(int N, int W, int W_arr[][], int d[], int index, int car1_x, int car1_y, int car2_x, int car2_y, int cost) {
////		if (index > W) 
//		//start index = 1; 첫번째 사고 경우 
//		int x = W_arr[index][1];
//		int y = W_arr[index][2];
//		func(N, W, W_arr, d, index+1, Math.abs(car1_x-x), Math.abs(car1_y-y), car2_x, car2_y, Math.abs(car1_x-x)+Math.abs(car1_y-y)) || func(N, W, W_arr, d, index+1, car1_x, car1_y, Math.abs(car2_x-x), Math.abs(car2_y-y), Math.abs(car2_x-x)+Math.abs(car2_y-y));;
//	}
//	public static void main(String[] args) throws IOException {
//		new no2618().init();
//	}
//}
