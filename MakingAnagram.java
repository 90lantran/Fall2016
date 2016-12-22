
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Output Format Print a single integer denoting the number of characters you
 * must delete to make the two strings anagrams of each other.
 * 
 * Sample Input cde abc
 * 
 * Sample Output 4
 * 
 */
public class MakingAnagram {
	public static int numberNeeded(String first, String second) {
		int answer = 0;
		Map<Character, Integer> data = new HashMap<Character, Integer>();
		for (Character c : first.toCharArray()) {
			if (data.containsKey(c)) {
				data.put(c, data.get(c) + 1);
			} else {
				data.put(c, 1);
			}
		}
	
		for (Character c : second.toCharArray()) {
			if (data.containsKey(c)) {
				System.out.println("Remove " + c);
				answer++;
				data.put(c, data.get(c) - 1);
				if (data.get(c) == 0) {
					data.remove(c);
				}
			}
		}

		return first.length() + second.length()  - 2*answer;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
