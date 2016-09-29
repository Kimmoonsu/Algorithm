import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
public class no10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> a = new HashSet<Integer>();
		String str[] = br.readLine().split(" ");
		for (int i = 0; i <str.length; i++) {
			a.add(Integer.parseInt(str[i]));
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder s = new StringBuilder();
		String str2[] = br.readLine().split(" ");
		for (int i = 0; i < str2.length; i++)  {
			if (a.contains(Integer.parseInt(str2[i]))) s.append("1 ");
			else s.append("0 ");
		}
		System.out.println(s);
	}
}
