import java.util.Scanner;
// ���� �ذ� ���
/*
  1. ���� ������ �ܰ���� 1��� ������ �Ͱ� 2��� ������ ���� ����� ���.
  2. ������ �迭�� ���� i��° ����� ��ġ�� 1��� �ö�� ������ 2��� �ö�� ������ ����.
  3. �޸����̼��� ���� 0�� ���� ���
  4. max�Լ��� ���� 1��� �����ϴ� �Ͱ� 2��� �����ϴ� ���� ū ���� ����
  5. ū ���� �����߱� ������ �� �κп� ����� ���� ���̻� ��� ���ص��ȴ�.
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
