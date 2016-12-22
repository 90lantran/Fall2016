import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Given an array of integers, return indices of the two numbers such that they add up 
 * to a specific target. You may assume that each input would have exactly one solution.
 * Example: 
 * 	Given nums = [2, 7, 11, 15], target = 9,
 *	Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */


/*
 *  Follow up : what if you have duplicate in your input
 *  Use HashSet
 *  Use LinkedHashSet
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {7,2,7, 11, 15};
		TwoSum obj = new TwoSum();
		Integer[] answers = twoSum(obj,nums, 9);
		for(Integer x : answers){
			System.out.println(x);
		}
	}
	 public class Pair{
		 Integer num;
		 Integer index;
		 public Pair(Integer num, Integer index){
			 this.num = num;
			 this.index = index;
		 }
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((index == null) ? 0 : index.hashCode());
			result = prime * result + ((num == null) ? 0 : num.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (index == null) {
				if (other.index != null)
					return false;
			} else if (!index.equals(other.index))
				return false;
			if (num == null) {
				if (other.num != null)
					return false;
			} else if (!num.equals(other.num))
				return false;
			return true;
		}
		private TwoSum getOuterType() {
			return TwoSum.this;
		}
		public Integer getNum() {
			return num;
		}
		public void setNum(Integer num) {
			this.num = num;
		}
		public Integer getIndex() {
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
	 }
	public static Integer[] twoSum(TwoSum obj, int[] nums, int target) {
		List<Integer> answers = new ArrayList<Integer>();
		
		LinkedHashSet<Pair> map = new LinkedHashSet<Pair>();
		
		
		for (int i = 0; i < nums.length; i++){
			map.add(obj.new Pair(nums[i],i));
		}
		
		for(Pair pair : map){
			Integer num = pair.getNum();
			
			for(Pair anotherPair : map){
				if (anotherPair.getNum().intValue() == (target - num)){
					
				}
			}
		}
		
		
		return answers.toArray(new Integer[answers.size()]);
	}
}
