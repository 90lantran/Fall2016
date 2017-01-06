import java.lang.reflect.Array;
import java.util.ArrayList;

public class findSubSet {
	public static void main(String[] args){
		int[] input = {1,2,3,4};
		findAllSubset(input);
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<ArrayList<Integer>> findAllSubset(int[] input){
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
		answer.add(new ArrayList<>());
		
		for (int x : input){
			System.out.println("Processing " + x );
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> arrayList : answer) {
				temp.add((ArrayList<Integer>)arrayList.clone());
			}
			for (ArrayList<Integer> currentList : temp){
				currentList.add(x);
			}
			answer.addAll(temp);
			
				System.out.println("After processing " + answer.toString() + " ");
			
		}
		
		
		return answer;
	}
}
