import java.util.Scanner;


public class prime {
	public static void main(String[] args) {
//		Start time
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num+1];
		for (int i = 2 ; i <= num; i ++)
		{
			arr[i] = i;
		}
		for (int i = 2; i <= num; i++)
		{
			if (arr[i] == 0)
				continue;
			for (int j = i+i; j <= num; j+=i)
			{
					arr[j] = 0;	
			}
		}
//		for (int i = 2; i <= num; i++)
//		{
//			if (arr[i]!=0)
//				System.out.println(arr[i]);
//		}

		// End time
		long endTime = System.currentTimeMillis();
		 
		// Total time
		long lTime = endTime - startTime;
		System.out.println("TIME : " + lTime + "(ms)");
	}
}
