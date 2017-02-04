import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no9498 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		char grade[] = {'F','F','F','F','F','F','D','C','B','A','A'};
		System.out.println(grade[num/10]);
		
	}
	public static void main(String[] args) throws IOException {
		new no9498().init();
	}
}
