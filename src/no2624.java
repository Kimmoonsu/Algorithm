import java.util.Arrays;
import java.util.Scanner;

public class no2624 {
	int price;
	int size;
	int coin[];
	int coin_cnt[];
	int cache[][] = new int[111][10010];
	void init()
	{
		Scanner sc = new Scanner(System.in);
		price = sc.nextInt();
		size = sc.nextInt();
		coin = new int[size];
		coin_cnt = new int[size];
		for (int i = 0; i < size; i++)
		{
			coin[i] = sc.nextInt();
			coin_cnt[i] = sc.nextInt();
		}
		for(int i=0;i<=size;i++) 
			for(int j=0;j<=price;j++) 
				cache[i][j]=-1;
		    System.out.printf("%d\n",dp(size-1,price));
		    for(int i=0;i<=size;i++){
		    	for(int j=0;j<=price;j++) 
					System.out.print(cache[i][j] + " ");
		    	System.out.println();
		    }
				
	}
	int dp(int index, int money) {
		
	    if(index==-1) {
	        if(money==0){
	        	 for(int i=0;i<=size;i++){
	 		    	for(int j=0;j<=price;j++) 
	 					System.out.print(cache[i][j] + " ");
	 		    	System.out.println();
	 		    }    	
	        	System.out.println();System.out.println();
	        	return 1;
	        }
	        else return 0;
	    }
	    if(cache[index][money]!=-1) return cache[index][money];
	    int i;
	    cache[index][money]=0;
	    //2,20
	    
	    for(i=0;i<=coin_cnt[index];i++) { //coin °¹¼ö
	    	if(money-coin[index]*i<0) break;
	    	cache[index][money]+=dp(index-1,money-coin[index]*i);
	    }
	    return cache[index][money];
	}
	public static void main(String[] args) {
		new no2624().init();
	}
}
