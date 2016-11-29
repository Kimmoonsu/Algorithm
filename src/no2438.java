import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2438 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
