import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class no1926 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		Vector<Integer>[] map = new Vector[city+1];
		for (int i = 1; i <= city; i++) map[i] = new Vector<Integer>();
		for (int i = 1; i <= 8; i++) {
//			String 
		}
	}
	public static void main(String[] args) throws IOException {
		new no1926().init();
	}
}
