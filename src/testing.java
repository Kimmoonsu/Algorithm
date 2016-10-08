import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class testing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pwd = sc.nextLine();
		String sha_pwd = SHA256(pwd);
		System.out.println("원래 비밀번호 : " + pwd);
		System.out.println("암호화된 비밀번호 : " + sha_pwd);
	}

	public static String SHA256(String str) {
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}

}