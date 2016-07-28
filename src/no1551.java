import java.util.Scanner;
import java.util.StringTokenizer;


public class no1551 {
	void init() {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int K = Integer.parseInt(sc.next());
		sc.nextLine();
		int arr[] = new int[N+1];
		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++)
			str = str.replace(',' , ' ');
		StringTokenizer st = new StringTokenizer(str);
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr = simulation(arr, N, K);
		for (int i = 1; i < N-K; i++)
			System.out.print(arr[i] + ",");
		System.out.println(arr[N-K]);
	}
	int[] simulation(int arr[], int N, int K) {
		for (int cnt = 1; cnt <= K; cnt++) {
			for (int i = 1; i < N; i++) {
				arr[i] = arr[i+1] - arr[i]; 
			}	
			N -= 1;		
		}
		return arr;
	}
	public static void main(String[] args) {
		new no1551().init();
	}
}
