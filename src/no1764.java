import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;


public class no1764 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (map.containsKey(input)) {
				map.put(input, 2);
			}
		}
		func(map);
	}
	void func(HashMap<String, Integer> map) {
		Iterator<Integer> value= map.values().iterator();
		while (value.hasNext()) {
			if (value.next() != 2) {
				value.remove();
			}
		}
		ArrayList<String> result = new ArrayList<String>(); 
		Iterator<String> key = map.keySet().iterator();
		while (key.hasNext()) {
			result.add(key.next());
		}
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()+"\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) +"\n");
		}
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		new no1764().init();
	}
}
