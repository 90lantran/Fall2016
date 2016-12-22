public class CheckBST {
	class Node {
		int data;
		Node left;
		Node right;
	}

	boolean checkBST(Node root) {
		return checkBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	boolean checkBSTHelper(Node root, int max, int min) {
		while (root != null) {
			if (checkData(max, min, root.data)) {
				return checkBSTHelper(root.left, root.data, min) && checkBSTHelper(root.right, max, root.data);
			} else {
				return false;
			}
		}
		return true;
	}

	static boolean checkData(int max, int min, int data) {
		if (data < max && data > min) {
			return true;
		} else {
			return false;
		}
	}
}
