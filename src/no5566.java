import java.util.Scanner;


public class no5566 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int dn[] = new int[n+1];	//주사위 판 값들  
		int dm[] = new int[m+1];	//던진 값 
		
		for(int i=1; i<=n; i++)
			dn[i] = sc.nextInt();
		for(int i=1; i<=m; i++)
			dm[i] = sc.nextInt();
		
		System.out.println(dice(n,m,dn,dm));
	}
	int dice(int n, int m, int[] dn, int[] dm){
		int move_count = 1;
		int position = 1;
		
		while (position < n) {
			position = position+dm[move_count];
			if (position > n) return move_count;
			position += dn[position];
			move_count++;
		}
		return move_count-1;
	}
	public static void main(String[] args) {
		new no5566().main();
	}
}
