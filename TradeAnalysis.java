import java.util.ArrayList;
import java.util.Scanner;


public class TradeAnalysis {
	public static Double CONST = Math.pow(10, 9) + 7;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] sequence = new int[n];
		String[] input = sc.nextLine().split(" ");
		for (int i = 0; i < input.length; i++){
			sequence[i] = Integer.parseInt(input[i]);
		}
		
		sc.close();
		
		ArrayList<ArrayList<Integer>> result = getSubSet(sequence);
		int sum = 0;
		
		for(ArrayList<Integer> e: result){
			sum = sum + subResult(e);
		}
		System.out.println(sum);
		
	}
	
	private static int subResult(ArrayList<Integer> e){
		int result = 1;
		for (Integer i : e){
			result = result * i ;
			result = (int) ((Integer)result % CONST);
		}
		return result*e.size();
	}
	
	private static ArrayList<ArrayList<Integer>> getSubSet(int[] sequence){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		// empty list
		ArrayList<Integer> empty = new ArrayList<Integer>();
		
		ArrayList<Integer> firstList = new ArrayList<Integer>();
		firstList.add(sequence[0]);
		
		result.add(empty);
		result.add(firstList);

		for(int i= 1; i < sequence.length; i++){
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> e : result){
				temp.add(new ArrayList<Integer>(e));
			}
			
			for (ArrayList<Integer> e: temp){
				e.add(sequence[i]);
			}
			result.addAll(temp);
			
		}
		
		return result;
	}
}
