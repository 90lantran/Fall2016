import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HappyNumber {
	public static int NUM_OF_INPUT = 1;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] input = new int[NUM_OF_INPUT];
		for(int i = 0; i < NUM_OF_INPUT; i++){
			input[i] = sc.nextInt();
		}
		
		for(int i = 0; i < NUM_OF_INPUT; i++){
			List<Integer> genratedSequence = new ArrayList<Integer>();
			genratedSequence.add(input[i]);
			int temp = calculateSumOfSquare(separateDigits(input[i]));
			if(temp == 1 ){
				System.out.print("Happy ");
				System.out.println(genratedSequence.get(genratedSequence.size() - 1));
				break;
			} else {
				genratedSequence.add(temp);
			}
		}
	}
	
	private static Integer[] separateDigits(int n){
		List<Integer> list = new ArrayList<Integer>();
		while(n > 0){
			list.add(n % 10);
			n = n /10;
		}
		for(Integer i : list){
			System.out.println(i);
		}
		return list.toArray(new Integer[list.size()]);
	}
	
	private static int calculateSumOfSquare(Integer[] input){
		int answer = 0;
		for (int i = 0; i < input.length; i++){
			answer += input[i]*input[i];
		}
		
		
		
		return answer;
	}
}
