import java.util.Scanner;


public class no10808 {
	int arr[] = new int[26];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
	
		for (int i = 0; i < str.length(); i++)
			arr[((int)(str.charAt(i))-'a')] ++;
		for (int i = 0; i < 26; i++)
			System.out.print(arr[i] + " ");
	}
	public static void main(String[] args) {
		new no10808().init();
	}
}
