import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Problem
 * 
 * You receive a credit C at a local store and would like to buy two items. You
 * first walk through the store and create a list L of all available items. From
 * this list you would like to buy two items that add up to the entire value of
 * the credit. The solution you provide will consist of the two integers
 * indicating the positions of the items in your list (smaller number first).
 * 
 * Input
 * 
 * The first line of input gives the number of cases, N. N test cases follow.
 * For each test case there will be:
 * 
 * One line containing the value C, the amount of credit you have at the store.
 * One line containing the value I, the number of items in the store. One line
 * containing a space separated list of I integers. Each integer P indicates the
 * price of an item in the store. Each test case will have exactly one solution.
 * 
 * @author alantran
 *
 */

public class Credit {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = Integer.valueOf(sc.nextLine());
		int[] credits = new int[n];
		ArrayList<ArrayList<String>> items = new ArrayList<>();
		
		for (int i = 0; i < n; i++){
			credits[i] = Integer.valueOf(sc.nextLine());
			int l = Integer.valueOf(sc.nextLine());
			String[] itemsValue = sc.nextLine().split(" ");
			items.add(i,new ArrayList<String>(Arrays.asList(itemsValue)));
			
			
			
		}
		
		for (int i = 0; i < n ; i++){
			int credit = credits[i];
			ArrayList<String> itemsValue = items.get(i);
			HashMap<Integer,Integer> map = new HashMap<>();
			for (int j = 0; j < itemsValue.size(); j++){
				int target = credit - Integer.valueOf(itemsValue.get(j));
				if (map.containsKey(target)){
					System.out.print(map.get(target) + 1);
						System.out.print(" ");
						System.out.println(j +1);
					break;
				} else {
					map.put(Integer.valueOf(itemsValue.get(j)), j);
				}
			}
			
			
		}
		
		
		
	}
}
