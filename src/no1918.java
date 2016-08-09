import java.util.Scanner;
import java.util.Stack;


public class no1918 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack s = new Stack();
		int cnt = 0;
		for (int i = 0 ; i < str.length(); i++)
		{
			if (str.charAt(i) == '(')
			{
				cnt ++;
			}
			else if (str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '+' || str.charAt(i) == '-')
				s.push(str.charAt(i));
			else if (str.charAt(i) == ')')
			{
				cnt --;
				if (cnt == 0)
				{
					int size = s.size();
					for (int j = 0 ; j < size; j++)
					{ 
						System.out.print(s.pop());
					}	
				}
				else
					System.out.print(s.pop());
				
			}
			else
			{
				System.out.print(str.charAt(i));
				if (i < str.length()-1 && i != 0 && s.size() >= 1 && str.charAt(i+1) != ')' && str.charAt(i-1) != '(' && str.charAt(i+1) != '*' && str.charAt(i+1) != '/' )
				{
					int size = s.size();
					for (int j = 0 ; j < size; j++)
					{ 
						System.out.print(s.pop());
					}	
				}
			}
		}
		int size = s.size();
		for (int j = 0 ; j < size; j++)
		{ 
			System.out.print(s.pop());
		}
		System.out.println();
			
	}
}
