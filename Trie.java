import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Trie {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie t = new Trie();
		TrieNode root = t.new TrieNode();
		List<Integer> arr = new ArrayList<Integer>();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			switch (op) {
			case "add":
				root.add(contact);
				break;
			case "find":
				arr.add(root.find(contact));
				break;
			}
		}
		for(Integer i : arr){
			System.out.println(i);
		}
	}
	
	/**
	 * Array implementation
	 * @author alantran
	 *
	 */
	public class TrieNode{
		private TrieNode[] children = new TrieNode[26];
		private int size = 0;
		
		private int getCharIndex(char c){
			return c - 'a';
		}
		
		private TrieNode getNode(char c){
			return children[getCharIndex(c)];
		}
		
		private void setNode(char c, TrieNode node){
			children[getCharIndex(c)] = node;
		}
	}
	
/**
 * HashMap Implementation 
 */
//	public class TrieNode {
//		private Map<String, TrieNode> children;
//		private Boolean isWord;
//
//		public TrieNode() {
//			children = new HashMap<String, TrieNode>();
//			isWord = false;
//		}
//
//		public void add(String s) {
//			addHelper(this, s, s.substring(0, 1), 1);
//		}
//
//		public void addHelper(TrieNode currentNode, String s, String subString, int index) {
//			if (index < s.length()) {
//				index++;
//				TrieNode nextNode;
//				if (currentNode.children.containsKey(subString)) {
//					// System.out.println(subString + " is in currentNode ");
//					nextNode = currentNode.children.get(subString);
//					for (Entry<String, TrieNode> e : nextNode.children.entrySet()) {
//						// System.out.println("Key " + e.getKey().toString());
//						// System.out.println("Value " +
//						// e.getValue().children.toString());
//					}
//				} else {
//					// System.out.println(subString + " is not in currentNode");
//					nextNode = new TrieNode();
//					currentNode.children.put(subString, nextNode);
//
//					for (Entry<String, TrieNode> e : currentNode.children.entrySet()) {
//						// System.out.println(e.getKey().toString());
//						// System.out.println(e.getValue().children.toString());
//					}
//
//				}
//
//				addHelper(nextNode, s, s.substring(0, index), index);
//			} else {
//				// System.out.println("Add " + subString + " to currentNode");
//				currentNode.children.put(subString, new TrieNode());
//				for (Entry<String, TrieNode> e : currentNode.children.entrySet()) {
//					// System.out.println(e.getKey().toString());
//					// System.out.println(e.getValue().children.toString());
//				}
//				currentNode.isWord = true;
//			}
//		}
//
//		public int find(String s) {
//			return findHelper(this, s, s.substring(0, 1), 1);
//		}
//
//		public int findHelper(TrieNode currentNode, String s, String subString, int index) {
//			// System.out.println("Look for " + subString + " from " + s);
//			if (index < s.length()) {
//				index++;
//				if (currentNode.children.containsKey(subString)) {
//					return findHelper(currentNode.children.get(subString), s, s.substring(0, index), index);
//				} else {
//					return 0;
//				}
//			} else {
//				if (currentNode.children.containsKey(subString)) {
//					
//					if (currentNode.isWord) {
//						return findAllValidWordsDFS(currentNode.children.get(subString), 1, new ArrayList<TrieNode>());
//					} else {
//						return findAllValidWordsDFS(currentNode.children.get(subString), 0, new ArrayList<TrieNode>());
//					}
//					
//				} else {
//					return 0;
//				}
//			}
//		}
//
//		public int findAllValidWordsDFS(TrieNode node, Integer count, List<TrieNode> visited) {
//			if (node.children.size() == 0) return count;
//			if (node.isWord) count++;
//			visited.add(node);
//			for (TrieNode t : node.children.values()){
//				if (!visited.contains(t)){
//					return findAllValidWordsDFS(t, count, visited);
//				}
//			}
//			return count;
//			
//		}
//
//		
//	}
}
