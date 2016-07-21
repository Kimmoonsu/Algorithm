import java.util.Scanner;

public class no9084 {
	private int price;
	private int size;
	private int[][] dp;
	private int coin[]; 
	private int sum=0;
	void init()
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		coin = new int[size];
		dp = new int[1000000][size];
		for (int i = 0; i< 1000000; i++)
			for (int j = 0 ; j < size; j ++)
				dp[i][j] = -1;
		for (int i = 0 ; i < size; i++)
			coin[i] = sc.nextInt();
		price = sc.nextInt();
		
		
		System.out.println(sum);
		for (int i = 0; i< 10; i++)
		{
			for (int j = 0 ; j < size; j ++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}				
	}
	
	public static void main(String[] args) {      
        int n,k;
  
        Scanner sc = new Scanner(System.in);
      //  int testcase = sc.nextInt();
      //  for (int test = 0; test < testcase; test++)
        {
        	int[] dp = new int[10001];
            dp[0] = 1;
        	int size = sc.nextInt();
        	int coin[] = new int[size];
        	
        	for (int i = 0; i < size; i++)
        		coin[i] = sc.nextInt();
        	int price = sc.nextInt();
        	for (int i = 0; i < size; i ++)
        	{
        		for (int j = coin[i]; j <= price; j++)
        		{
        			dp[j] += dp[j-coin[i]];
        		}
        		for (int j = 0; j <= price; j ++)
        			System.out.print(dp[j] + " ");	
        		System.out.println();
        	}
        	
            System.out.println(dp[price]);
     	
        }
        
    }
//	public static void main(String[] args) {
//		new no9084().init();
//		
//	}
}
