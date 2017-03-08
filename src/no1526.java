import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no1526 {
	static int N;
	static int result;
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(4);
		dfs(7);
		System.out.println(result);
	}
	void dfs(int number) {
		if (number > N) return;
		result = Math.max(result, number);
		dfs(number*10 + 4);
		dfs(number*10 + 7);
	}
	public static void main(String[] args) throws IOException {
		new no1526().init();
		
	}
	// 147 -> 77
	//460-> 447
	// 700 -> 477
}
