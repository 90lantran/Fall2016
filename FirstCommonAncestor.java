import java.util.ArrayList;
import java.util.List;

public class FirstCommonAncestor {
	class Node{
		private int value;
		private Node left;
		private Node right;
	}
	
	public static int findFirstCommonAncestor(Node root, Node first, Node second){
		List<Integer> path1 = findPathToNode(root, first, new ArrayList<>());
		List<Integer> path2 = findPathToNode(root, second, new ArrayList<>());
		for(Integer x : path1){
			if (path2.contains(x)){
				return x;
			}
		}
		return -1;
	}
	
	public static List<Integer> findPathToNode(Node root, Node target, List<Integer> path){
		if (root == null ){
			return new ArrayList<>();
		}
		if (root.value == target.value){
			return path;
		}
		path.add(root.value);
		
		if (root.value < target.value){
			return findPathToNode(root.right, target, new ArrayList<>(path));
		} else {
			return findPathToNode(root.left, target, new ArrayList<>(path));
		}
		
	}
}
