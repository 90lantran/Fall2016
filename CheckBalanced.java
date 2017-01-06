import java.util.ArrayList;
import java.util.List;

public class CheckBalanced {
	class Node{
		private int value;
		private Node left;
		private Node right;
	}
	
	public static boolean checkBalanced(Node root){
		
		return getHeight(root) != Integer.MIN_VALUE;
	}
	
	public static int getHeight(Node root){
		if (root == null){
			return -1;
		} 
		int leftHeight = getHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight = getHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if (Math.abs(leftHeight - rightHeight) > 1){
			return Integer.MIN_VALUE;
		} else {
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}
}
