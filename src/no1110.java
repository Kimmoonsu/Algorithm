import java.util.Scanner;
 
 
public class no1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 1;
        int x = N/10;
        int y = N%10;
        boolean check = true;
        while(check) {
            int sum = x + y;
            if ( ( (y * 10) + (sum % 10) ) == N) check = false;
            else {
                cnt ++;
                x = y;
                y = sum%10;
            }
        }
        System.out.println(cnt);
    }
}