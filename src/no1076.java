import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedHashMap;


public class no1076 {
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input_color[] = new String[4];
		for (int i = 0; i < 3; i++) input_color[i] = br.readLine();
		String color[] = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
		LinkedHashMap<String, Integer> map2 = new LinkedHashMap<String,Integer>();
		int num = 1;
		for (int i = 0; i <= 9; i++) {
			map.put(color[i], ""+i);
			map2.put(color[i], num);
			num = num*10;	
		}
		System.out.println(func(input_color, map, map2));
	}
	BigInteger func(String[] input_color, LinkedHashMap<String, String> map, LinkedHashMap<String, Integer> map2) {
		String result = "";
		result = map.get(input_color[0]);
		result += map.get(input_color[1]);
		BigInteger num = new BigInteger("0");
		num = new BigInteger(result).multiply(new BigInteger(""+map2.get(input_color[2])));
		return num;
	}
	public static void main(String[] args) throws IOException {
		new no1076().init();
	}
}
