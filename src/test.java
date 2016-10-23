import java.util.HashSet;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		s.add(2);
		s.add(3);
		System.out.println(s);
		
	}
}