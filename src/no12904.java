import java.util.Scanner;


public class no12904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer S = new StringBuffer(sc.nextLine());
		StringBuffer T = new StringBuffer(sc.nextLine());		
		while(S.length() != T.length()) {
			char t = T.charAt(T.length()-1);
			T.delete(T.length()-1, T.length());
			if (t == 'B') T.reverse();
		}
		if (S.toString().equals(T.toString())) System.out.println(1);
		else System.out.println(0);
	}
}
