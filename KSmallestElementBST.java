import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KSmallestElementBST {
	public class Node {
		private int value;
		private Node left;
		private Node right;
	}

	public int findKSmallElementBST(Node root, int k) {
		Stack<Node> s = new Stack<>();
		while (root != null) {
			s.push(root.left);
			root = root.left;
		}

		int count = 0;
		while (!s.isEmpty()) {
			Node temp = s.pop();
			count++;

			if (count == k) {
				return temp.value;
			}

			Node rightOdTemp = temp.right;
			while (rightOdTemp != null) {
				s.push(rightOdTemp);
				rightOdTemp = rightOdTemp.left;
			}
		}
		return 0;
	}
	
	public void flattenBST(Node root, List<Integer> answer){
		if (root != null){
			flattenBST(root.left, answer);
			answer.add(root.value);
			flattenBST(root.right, answer);
		}
	}
}
