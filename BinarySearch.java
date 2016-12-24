
public class BinarySearch {
	public static void main(String[] args){
		int[] input = {3,6 ,7,10, 32, 44,57};
		System.out.println(search(input, 57, 0, input.length -1));
	}
	
	private static boolean search(int[] input, int target, int low, int high){
		if (high == low){
			return target == input[high];
		}
		int mid = (low + high)/2;
		if (target == input[mid]){
			return true;
		} else if ( target < input[mid]) {
			return search(input, target, low, mid -1);
		} else {
			return search (input, target, low +1, high);
		}
	}
}
