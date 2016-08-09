import java.util.Scanner;


public class no10798 {
	private char[][] char_arr = new char[5][15];
	
	void init()
	{
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i ++)
		{
			String str = sc.nextLine();
			for (int j = 0 ; j < str.length(); j++)
				char_arr[i][j] = str.charAt(j);
		}
		for (int j = 0 ; j < 15; j ++)
		{
			for (int i = 0 ; i < 5; i++)
			{
				if (char_arr[i][j] != '\0')
					System.out.print(char_arr[i][j]);		
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		new no10798().init();
	}
}
