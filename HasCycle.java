import java.util.ArrayList;
import java.util.List;

public class HasCycle {
	/*
	 * Detect a cycle in a linked list. Note that the head pointer may be 'null'
	 * if the list is empty.
	 */
	class Node {
		int data;
		Node next;
	}

	boolean hasCycle(Node head) {
		List<Node> visited = new ArrayList<Node>();
		return hasCycleHelper(head, visited);
	}

	static boolean hasCycleHelper(Node node, List<Node> visited) {
		if (node == null)
			return false;
		if (visited.contains(node))
			return true;
		visited.add(node);
		return hasCycleHelper(node.next, visited);
	}
}
