import java.util.Scanner;


public class no2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 1;
		for (int i = 0 ; i < 3; i++)
			size *= sc.nextInt();
		int arr[] = new int[10]; // 0~9���� ���� Ƚ���� ������ �迭
		
		// ���� ������ ũ�⸸ŭ �ݺ����� ����.
		for (int i = 0 ; i < String.valueOf(size).length(); i++)
		{
			arr[(int)(String.valueOf(size).charAt(i))-48] ++; // ù��° �ڸ����� String -> char -> int�� ��ȯ�� �� �ش� ���� �ε����� +1
		}
		
		// ���
		for (int i = 0 ; i < 10; i ++)
			System.out.println(arr[i]);
		
	}
}
