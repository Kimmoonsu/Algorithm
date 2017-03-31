import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no6603 {
	static StringBuilder sb = new StringBuilder();
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean state = true;
		while (state) {
			String str[] = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			if (N == 0) state = false;
			else {				
				int map[] = new int[N+1];
				for (int i = 1; i <= N; i++) {
					map[i] = Integer.parseInt(str[i]);
				}
				String result = "";
				dfs(N, map, 0, result, N-5, 0);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	void dfs(int N, int map[], int index, String result, int size, int count) {
//		System.out.println("result : " + result + "/ " + index + " , " + size);
		if (count == 6) {
			sb.append(result + "" + map[index] + "\n");
//			System.out.println(sb);
			result.substring(0, result.length()-3);
			return;
		}
		if (index != 0)
			result += ""+map[index] + " ";
		for (int i = 1; i <= size; i++) {
			if (index+i <= N)
				dfs(N, map, index+i, result, size, count+1);
		}
	}
	public static void main(String[] args) throws IOException {
		new no6603().init();
	}
}
