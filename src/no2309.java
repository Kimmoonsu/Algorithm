import java.util.Queue;
import java.util.Scanner;


public class no2309 {
	private int arr[] = new int[9];
	public no2309(){}
	void init()
	{
		Scanner sc = new Scanner(System.in);
		for (int i = 0 ; i < 9; i++)
			arr[i] = sc.nextInt();
	}
	//버블 정렬
	void sort()
	{
		for (int i = 8 ; i >= 0; i--)
		{
			for (int j = 0; j < i; j++)
			if (arr[j] > arr[j+1])
			{
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
	int[] findSort(int find_arr[])
	{
		for (int i = 6 ; i >= 0; i--)
		{
			for (int j = 0; j < i; j++)
			if (find_arr[j] > find_arr[j+1])
			{
				int temp = find_arr[j];
				find_arr[j] = find_arr[j+1];
				find_arr[j+1] = temp;
			}
		}
		return find_arr;
	}
	void find()
	{
		int que1[] = new int[7];
		int que2[] = new int[2];
		
		for (int l = 0; l < 3; l ++)
		{
			if (l == 0)
			{
				que2[0] = arr[7];
				que2[1] = arr[8];
			}
			else if (l == 1)
			{
				que2[0] = arr[0];
				que2[1] = arr[8];
			}
			else if (l == 2)
			{
				que2[0] = arr[0];
				que2[1] = arr[1];
				int sum = 0;
				for (int i = l; i < 7+l; i ++)
				{
					que1[i] +=arr[i];
					sum += que1[i];
					
				}
				if (sum==100)
				{
					que1 = findSort(que1);
					for (int cnt = 0 ; cnt < 7; cnt++)
						System.out.println(que1[cnt]);
					return;
				}
			}
			
			for (int j = 6-l ; j >= 0; j --)
			{
				for (int i = l; i < 7+l; i ++)
				{
					que1[i] = arr[i];
				}
				for (int k = l ; k < 2; k ++)
				{
					int sum = 0;
					for (int i = 0; i < 7; i ++)
					{
						sum += que1[i];
					}
					if (sum == 100)
					{
						que1 = findSort(que1);
						for (int cnt = 0 ; cnt < 7; cnt++)
							System.out.println(que1[cnt]);
						return;
					}
					else 
					{
						que1[j] = que2[k];						
					}	
				}
							
			}	
		}
		
		
	}
	public static void main(String[] args) {
		no2309 m = new no2309();
		m.init();
		m.sort();
		m.find();
	}
}
