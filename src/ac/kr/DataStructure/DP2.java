package ac.kr.DataStructure;

import java.util.Scanner;

// 종만북 p 220 ( 문제 : 와일드카드 난이도 : 중 )
public class DP2 {
	public static int cache[][] = new int[101][101];
	static String W, S;
	public static int matchMemoized(int w, int s)
	{
		System.out.println("시작 w : " + W.charAt(w) + " S : " + S.charAt(s));
		// 메모제이션
		if (cache[w][s] != -1 ) return cache[w][s];
		
		// W[w]와 [S][s]를 맞춰나간다.
		while( s < S.length() && w < W.length() && ( W.charAt(w) == '?' || W.charAt(w) == S.charAt(s) ) )
		{
			System.out.println("w : " + W.charAt(w) + " S : " + S.charAt(s));
			w ++;
			s ++;
		}
		
		//더이상 대응할 수 없으면 왜 while문이 끝났는지 확인한다.
		// 2. 패턴 끝에 도달해서 끝난 경우 : 문자열도 끝났어야 참
		if (w == W.length()) return cache[w][s] = (s == S.length()) ? 1 : 0;
		// 4. *를 만나서 끝난 경우 : *에 몇 글자를 대응해야 할지 재귀 호출하면서 확인한다.
		if (W.charAt(w) == '*')
			for (int skip = 0; skip+s <= S.length(); ++skip)
				if (matchMemoized(w+1, s+skip) == 1)
					return cache[w][s] = 1;
		
		//이 외의 경우에는 모두 대응되지 않는다.
		return cache[w][s] = 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int testcase = Integer.parseInt(sc.nextLine());
		
//		for (int i = 0 ; i < testcase ; i++)
//		{
//			S = "";
//			W = "";
//			for (int j = 0 ; j < cache.length; j++)
//			{
//				for (int k = 0; k < cache.length; k++)
//					cache[j][k] = -1;
//			}
//			W = sc.nextLine();
//			int n = Integer.parseInt(sc.nextLine());
//			int check = 0;
//			for (int j = 0 ; j < n ; j++)
//			{
//				S = sc.nextLine();
//				check = matchMemoized(0,0);
//				if (check == 1)
//					System.out.println(S);
//			}
//		}
//		
		W = "he?p";
		S = "help";
		int check = matchMemoized(0,0);
		if (check == 1)
			System.out.println(S);
//		for (int i = 0 ; i < cache.length; i++)
//		{
//			for (int j = 0; j < cache.length; j++)
//				System.out.print(cache[i][j] + "   ");
//			System.out.println();
//		}
		
		
	}
}
