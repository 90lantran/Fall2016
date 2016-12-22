import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Alarm {

	static String isPangram(String[] strings) {
		StringBuilder result  = new StringBuilder();
		for (String s : strings) {
			String[] words = s.split(" ");
			Boolean[] alphabet = new Boolean[26];
			for (String word : words) {
				for (char character : word.toCharArray()) {
					alphabet[character - 'q'] = true;
				}
			}
			for( Boolean b : alphabet){
				if (b == false){
					result.append("0");
					break;
				}	
			}
			result.append("1");
		}			
		return result.toString();
	}
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        
        int _strings_size = 0;
        _strings_size = Integer.parseInt(in.nextLine());
        String[] _strings = new String[_strings_size];
        String _strings_item;
        for(int _strings_i = 0; _strings_i < _strings_size; _strings_i++) {
            try {
                _strings_item = in.nextLine();
            } catch (Exception e) {
                _strings_item = null;
            }
            _strings[_strings_i] = _strings_item;
        }
        
        res = isPangram(_strings);
        
        
//        bw.write(res);
//        bw.newLine();
//        
//        bw.close();
    }
	
	 static int minUnfairness(int k, int[] arr) {
		 Arrays.sort(arr);
		 int[] packets = Arrays.copyOfRange(arr, 0, k-1);
		 return packets[packets.length -1] - packets[0];
		
	 }
	 
	 


}
