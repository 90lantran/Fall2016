import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StairCase {
	    
	    public static int solve(int n, Map<Integer, Integer> memo){
	    	if (memo.containsKey(n)) return memo.get(n);
	        if (n < 0){
	            return 0;
	        } else if ( n == 0){
	            return 1;
	        } else {
	            int temp =  solve(n-1, memo) + solve(n-2, memo) + solve (n-3, memo);
	            memo.put(n, temp);
	            return temp;
	        }
	    }
	    public static void main(String[] args) {
	    	Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
	        Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        for(int a0 = 0; a0 < s; a0++){
	            int n = in.nextInt();
	            System.out.println(solve(n, memo));
	        }
	    }
}
