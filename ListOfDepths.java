import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * create d lists of node from a binary tree of height d, each list will be a level o
 * @author alantran
 *
 */
public class ListOfDepths {
	class Node {
		private int value;
		Node left;
		Node right;
	}
	
	public void BFSModification1(Node node){
		Queue<Node> willProcess = new LinkedList<>();
		Queue<Integer> levels = new LinkedList<>();
		Map<Integer, List<Node>> answers = new HashMap<>();
		willProcess.add(node);
		levels.add(1);
		List<Node> temp;

		while(!willProcess.isEmpty()){
			Node currentNode = willProcess.poll();
			Integer currentLevel = levels.poll();
			if (answers.containsKey(currentLevel)){
				answers.get(currentLevel).add(currentNode);
			} else {
				temp = new ArrayList<>();
				temp.add(currentNode);
				answers.put(currentLevel, temp);
			}
			
			Integer newLevel = currentLevel++;
			willProcess.add(currentNode.left);
			levels.add(newLevel);
			willProcess.add(currentNode.right);
			levels.add(newLevel);
		}
	}
	
	public List<LinkedList<Node>> BFSModification2(Node root){
		List<LinkedList<Node>> answer = new ArrayList<>();
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(root);
		//answer.add(currentList);
		while (!currentList.isEmpty()){
			LinkedList<Node> parents = currentList;
			answer.add(currentList);
			currentList = new LinkedList<Node>();
			for(Node node : parents){
				if (node.left != null) currentList.add(node.left);
				if (node.right != null) currentList.add(node.right);
			}
		}
		return answer;
	}
	
	
}
