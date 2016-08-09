import java.util.Scanner;
// 문제 해결 방법
/*
  1. 제일 마지막 단계부터 1계단 오르는 것과 2계단 오르는 것을 나누어서 계산.
  2. 이차원 배열을 통해 i번째 계단의 위치에 1계단 올라온 것인지 2계단 올라온 것인지 저장.
  3. 메모제이션을 통해 0일 때만 계산
  4. max함수를 통해 1계단 점프하는 것과 2계단 점프하는 것중 큰 값을 저장
  5. 큰 값을 저장했기 때문에 그 부분에 저장된 경우는 더이상 계산 안해도된다.
 */

public class no2579 {
	int size;
	int[] arr;
	int [][] stair;
	int jump(int x, int cnt)
	{
		System.out.println("x : " + x + " cnt : " + cnt);
		for (int i = 0 ; i < size; i ++)
		{
			for (int j = 0 ; j < 2; j ++)
				System.out.print(stair[i][j] + " ");
			System.out.println();
		}
		
		if (stair[x][cnt] == 0)
		{
			int val = arr[x];
			System.out.println("val : " + val);
			if (x > 1)
			{
				if (cnt == 0)
					val += max(jump(x-1, 1), jump(x-2, 0));
				else 
					val += jump(x-2, 0);
			}
			else if (x == 1 && cnt == 0)
				val += arr[x-1];			
			stair[x][cnt] = val;
			return val;	
		}
		else
			return stair[x][cnt];
			
	}
	int max(int x, int y) {
		    return x = x >= y ? x : y;
	}
	void init()
	{
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		arr = new int[size];
		stair = new int[size][2];
		for (int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println(jump(size-1, 0));
	}
	
	public static void main(String[] args) {
		new no2579().init();
	}
}
