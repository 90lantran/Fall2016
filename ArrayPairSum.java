import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array, output all pairs that sum up to a specific value k.
 * @author alantran
 *
 *author's answer : use Set
 */
public class ArrayPairSum {
	Set<Integer> set = new HashSet<>();
	/*
	 * Assume that all values are unique
	 */
	public void findAllPairSum(int[] input, int k){
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : input){
			if (map.containsKey(k-i)){
				System.out.println((k-i) + " "+ map.get(k-i));
				map.remove(k-i);
			} else {
				map.put(i, k - i);
			}
		}
	}
}
