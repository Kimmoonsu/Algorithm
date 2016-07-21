package ac.kr.DataStructure;

import java.util.Scanner;

// ������ p 220 ( ���� : ���ϵ�ī�� ���̵� : �� )
public class DP2 {
	public static int cache[][] = new int[101][101];
	static String W, S;
	public static int matchMemoized(int w, int s)
	{
		System.out.println("���� w : " + W.charAt(w) + " S : " + S.charAt(s));
		// �޸����̼�
		if (cache[w][s] != -1 ) return cache[w][s];
		
		// W[w]�� [S][s]�� ���糪����.
		while( s < S.length() && w < W.length() && ( W.charAt(w) == '?' || W.charAt(w) == S.charAt(s) ) )
		{
			System.out.println("w : " + W.charAt(w) + " S : " + S.charAt(s));
			w ++;
			s ++;
		}
		
		//���̻� ������ �� ������ �� while���� �������� Ȯ���Ѵ�.
		// 2. ���� ���� �����ؼ� ���� ��� : ���ڿ��� ������� ��
		if (w == W.length()) return cache[w][s] = (s == S.length()) ? 1 : 0;
		// 4. *�� ������ ���� ��� : *�� �� ���ڸ� �����ؾ� ���� ��� ȣ���ϸ鼭 Ȯ���Ѵ�.
		if (W.charAt(w) == '*')
			for (int skip = 0; skip+s <= S.length(); ++skip)
				if (matchMemoized(w+1, s+skip) == 1)
					return cache[w][s] = 1;
		
		//�� ���� ��쿡�� ��� �������� �ʴ´�.
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
