
public class Coopang1 {
	public static String[] solution(String[] inputs) {
		String[] outputs_list = {"arr1", "arr2", "arr3"};
		int N = inputs.length/3 + 1;
		String[] outputs = new String[inputs.length];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inputs.length; i+=3) {
			for (int j = 0; j < 3; j++) {
				if (i+j >= inputs.length) break;
				sb.append("["+outputs_list[j] + "," + inputs[i+j]+"]");
				outputs[i+j] = "["+outputs_list[j] + "," + inputs[i+j]+"]";
			}
		}
		for (int i = 0; i < outputs.length; i++) System.out.print(outputs[i] +" ");
		
		return new String[]{};
	}
	public static void main(String[] args) {
		String[] inputs = {"a", "b", "c", "d", "e","f","g","h"};
		solution(inputs);
	}
}
