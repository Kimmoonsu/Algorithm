
public class Coopang3 {
	public static int solution(String str) {
        int n=str.length();
        for(int i=0;i<n;i++){
            boolean state = true;
            for(int j=0;2*j+i<n;j++){
                if(str.charAt(i+j)!=str.charAt(n-1-j)){
                    state = false;
                    break;
                }
            }
            if(state){
                return i+n;
            }
        }
		return 0;
        
	}
	public static void main(String[] args) {
		System.out.println(solution("oncoder"));
	}
}
