import java.util.Scanner;
import java.util.StringTokenizer;


public class no2902 {
	void init()
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = replaceChar(str);
		StringTokenizer st = new StringTokenizer(str);
		int length = st.countTokens();
		for (int i = 0; i < length; i++) {
			String token_str = st.nextToken();
			System.out.print(token_str.charAt(0));
		}
	}
	String replaceChar(String str)
	{
		String replace_str = str;
		replace_str = str.replace('-', ' ');
		return replace_str;
	}
	public static void main(String[] args) {
		new no2902().init();
	}
}
