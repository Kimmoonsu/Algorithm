import java.util.*;

public class subject {
	public static String login_table[][] = {
			{ "윤용상", "강은주", "설혜린", "강혜수", "김연정" },
			{ "123", "apple", "789", "12345", "111111" }
	};	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		int check_count = 3;
		while (check_count > 0) {
			int find_idindex = login_table[0].length; // int 최댓값으로 초기화
			System.out.println("아이디를 입력하세요:");
			String input_id = sc.nextLine();
			System.out.println("비밀번호를 입력하세요:");
			String input_password = sc.nextLine();
			checkLogin(find_idindex, input_id, input_password);
			check_count--;
		}		
	}
	public static void checkLogin(int find_idindex, String input_id, String input_password) {
		for (int i = 0; i < login_table[0].length; i++) {
			if (input_id.compareTo(login_table[0][i]) == 0) {
				find_idindex = i;
			}
		}
		if (find_idindex >= 5) {
			System.out.println("아이디 불일치");
		} else if (input_password.compareTo(login_table[1][find_idindex]) == 0)
			System.out.println("로그인 되었습니다.");
		else {
			System.out.println("비밀번호 불일치");
		}
	}
	public static void main(String[] args) {
		start();
	}
}
