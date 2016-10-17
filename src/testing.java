import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

public class testing {
	public static void main(String[] args) throws IOException {
		// questionRead("20161010");
		File file = new File("/Users/Kimmoonsu/Desktop/20161010question.txt");
		String result = "";
		String test = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "utf-8"));
        String data[] = new String[6];
        int cnt = 0;
        // readLine 사용해 한 라인씩 읽어들인다
        while ((test = br.readLine()) != null){
        	result += test;
        }
		br.close();
		System.out.println(result);
	}
	// public static String[] questionRead(String today) throws IOException {
	//
	//
	// return data;
	// }
}