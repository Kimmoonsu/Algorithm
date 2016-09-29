import java.io.BufferedReader;
import java.io.InputStreamReader;


public class c_test {
	public static void main(String[] args) {
		try{
//			Runtime.getRuntime().exec("bash --login '/Applications/Docker/Docker Quickstart Terminal.app/Contents/Resources/Scripts/start.sh'");
//			Runtime.getRuntime().exec("docker run -it -v $HOME/tf_files:/tf_files  gcr.io/tensorflow/tensorflow:latest-devel");
//			Runtime.getRuntime().exec("cd /Users/Kimmoonsu/Desktop");
//			String command = "ls /Users/Kimmoonsu/Desktop";
			String[] cmd = 
				{
				"python","/Users/Kimmoonsu/tf_files/label_image.py", "/Users/Kimmoonsu/tf_files/sejongpic.jpg"
				}; 
			Process process = Runtime.getRuntime().exec(cmd);
			process.getErrorStream().close();
//			process.getInputStream().close();
			process.getOutputStream().close();
			process.waitFor();
		    BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		    String line = null;
		    while((line = br.readLine()) != null){
		        System.out.println(line);
		    }
		 }catch(Exception e){
		    System.out.println(e);
		}
//		String[] cmd = 
//				{
//				"python","/Users/Kimmoonsu/tf_files/bash.py"
//				};
//		 Runtime rt = Runtime.getRuntime();
//         Process p;
//          
//         try {
//             p = rt.exec(cmd);
//             p.waitFor();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
	}
}
