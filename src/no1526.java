import java.util.Scanner;


public class no1526 {
	String result="";
	void init() {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		func(N);
	}
	void func(String N) {
		if (((int)N.charAt(0)-48) < 4) {
			for (int i = 0; i < N.length()-1; i++) 
				System.out.print(7);
		}
		else {
			boolean state = false;
			for (int i = 0; i < N.length(); i++) {
				if (state) result += "7";
				else {
					int num = N.charAt(i)-48;
					if (num < 4) {
						int n = (int)result.charAt(result.length()-1)-48;
						System.out.println("num : " + n);
						result = result.substring(0, result.length()-1);
						result += n == 4 ? "7" : "4";
						result += "7";
					}
					else if (num > 7) {
						result += "7";
						state = true;
					} else if (num == 4 || num == 7) result += String.valueOf(num);
					else if (num < 7) {
						result += "4";
						state = true;
					}
				}
				
			}
			
			System.out.println(result);
		}
		
	}
	
	public static void main(String[] args) {
		new no1526().init();
		
	}
}
