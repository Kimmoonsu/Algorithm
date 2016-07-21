import java.util.Scanner;


public class no2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 1;
		for (int i = 0 ; i < 3; i++)
			size *= sc.nextInt();
		int arr[] = new int[10]; // 0~9까지 나온 횟수를 저장할 배열
		
		// 곱한 숫자의 크기만큼 반복문이 돈다.
		for (int i = 0 ; i < String.valueOf(size).length(); i++)
		{
			arr[(int)(String.valueOf(size).charAt(i))-48] ++; // 첫번째 자리부터 String -> char -> int로 변환한 뒤 해당 숫자 인덱스에 +1
		}
		
		// 출력
		for (int i = 0 ; i < 10; i ++)
			System.out.println(arr[i]);
		
	}
}
