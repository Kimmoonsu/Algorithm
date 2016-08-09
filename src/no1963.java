import java.util.ArrayList;
import java.util.Scanner;


public class no1963 {
	private Scanner sc;
	private int prime1, prime2;
	private int check = 0;
	private int arr[] = new int[10000+1];
	private ArrayList<Integer>prime = new ArrayList<Integer>(); // 1000이상의 소수
	private char prime_arr1[] = new char[4];
	private char prime_arr2[] = new char[4];
	public no1963(Scanner sc)
	{
		this.sc = sc;
	}
	void init()
	{
		prime1 = sc.nextInt();
		prime2 = sc.nextInt();
		
		
		/*******에라토스테네스 소수 초기화********/
		for (int i = 2 ; i <= 10000; i ++)
		{
			arr[i] = i;
		}
		for (int i = 2; i <= 10000; i++)
		{
			if (arr[i] == 0)
				continue;
			for (int j = i+i; j <= 10000; j+=i)
			{
					arr[j] = 0;	
			}
		}
		for (int i = 2; i <= 10000; i++)
		{
			if (arr[i] != 0 && arr[i] >=prime1 && arr[i] <= prime2)
			{
				//System.out.println("arr: " + arr[i]);
				prime.add(arr[i]);
			}
		}
		/*********************************/
		
		
		
		// 숫자를 char형태로 배열에 저장.
		for (int i = 0 ; i < 4; i++)
		{
			prime_arr1[i] = String.valueOf(prime1).charAt(i);
			prime_arr2[i] = String.valueOf(prime2).charAt(i);
		}
	}
	void compare()
	{
		if (prime1 == prime2)
			System.out.println("0");
		else
		{
			
			for (int i = 0 ; i < prime.size(); i ++)
			{
				
				int count = 0;
				for (int j = 1; j < 4; j++)
				{
					System.out.println("i : " + i + " prime1 : " + prime1 + " prime : " + prime.get(i));
					if (prime_arr1[j] == String.valueOf(prime.get(i)).charAt(j))
						count ++;
				}
				//System.out.println("arr : " + prime_arr1[0] + "" + prime_arr1[1] + "" + prime_arr1[2] + "" + prime_arr1[3]);
				if (count == 3)
				{
					prime1 = prime.get(i);
					check ++;
				}
				if (prime1 == prime2)
				{
					System.out.println(check);
					break;
				}
				else
				{
					char temp = prime_arr1[0];
					for (int k = 0 ; k < 3; k ++)
						prime_arr1[k] = prime_arr1[k+1];
					prime_arr1[3] = temp;
					i = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		no1963 m[] = new no1963[testcase];
		for (int i = 0; i < testcase; i ++)
		{
			m[i] = new no1963(sc);
			m[i].init();
			m[i].compare();
		}
	}
}
