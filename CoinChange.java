import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * There are 2 questions with this question. 1. Find number of ways to make
 * change 2. Find the smallest number of coins to make change.
 * 
 * Here we will try to solve the first one.
 * 
 * @author alantran
 *
 */
public class CoinChange {

	// Iteratively
	// That is bottom-up, try to build an array in flight
	static long countWays(int S[], int m, int n) {
		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]]; // This is similar to writing
												// recursion expression in 451
												// class

		return table[n];
	}

	// recursively
	// top-down, using memo table

	public static long makeChange(int[] coins, int money, Map<String, Long> memo) {
        if (memo.containsKey(money + "-" + coins.length)) return memo.get(money + "-" + coins.length);
        if (money < 0 || coins.length <= 0){
            return 0;
        } else if (money == 0){
            return 1;
        } else {
           int[] newArr = new int[coins.length -1];
			System.arraycopy(coins, 0, newArr, 0, coins.length - 1);
			long temp = makeChange(coins, money - coins[coins.length - 1], memo) + makeChange(newArr, money, memo);
            String key = money + "-" + coins.length;
            memo.put(key, temp);
            return temp;
        }
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = in.nextInt();
		}
		Map<String, Long> memo = new HashMap<String, Long>();

		System.out.println(makeChange(coins, n, memo));
	}

}
