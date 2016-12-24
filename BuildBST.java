/**
 * Build a BST from a sorted integer array with mininal height
 * @author alantran
 *
 */
public class BuildBST {
	public class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value, Node left, Node right){
			this.value = value;
			left = this.left;
			right = this.right;
		}
	}
	
	public static void buildBST(int[] input){
		
	}
	
	public static void buildBSTHelper(int[] input, int low, int high){
		if (high == low){
			insert(input[high]);
			return;
		}
		
		int mid = (high + low)/2;
		insert(mid);
		buildBSTHelper(input, low, mid -1);
		buildBSTHelper(input, mid + 1, high);
		
	}
	
	public static void insert(int value){
		
	}
	
	
	
	
}
