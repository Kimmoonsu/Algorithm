import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no1783 {
	void init() throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int height = Integer.parseInt(input[0]);
		int width = Integer.parseInt(input[1]);
		System.out.println(func(height, width));
	}
	int func(int height, int width) {
		if (height == 1) return 1;
		else if (height == 2) return Math.min(4, (width+1)/2);
		else  {
			if (width >= 7) return width-2;
			else return Math.min(4, width);
		}
	}
	public static void main(String[] args) throws IOException {
		new no1783().init();
	}
}
