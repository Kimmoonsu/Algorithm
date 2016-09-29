import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;


public class no7785 {
	void init () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> people = new HashSet<String>();
		for (int i = 0; i < N; i++) {			
			String str[] = br.readLine().split(" ");
			if (str[1].equals("enter")) people.add(str[0]);
			else people.remove(str[0]);
		}
		func(people);
	}
	void func(HashSet<String> people) {
		Iterator<String> keys = people.iterator();
		ArrayList<String> arr = new ArrayList<String>();
		while (keys.hasNext()) {
			arr.add(keys.next());
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = arr.size()-1; i >= 0; i--) {
			sb.append(arr.get(i));
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new no7785().init();
	}
}
