/**
 * Given a linkedlist of integers and an integer value, delete every node of the
 * linkedlist containing that value.
 * 
 * @author alantran 7 steps to solve coding problems: 1: Read the problem, try
 *         to understand it 2: Identify input, and output 3: More examples,
 *         corner cases 4: See the logic and come up with algorithm 5:
 *         Complexity 6: Write code 7: Run code by hand
 *
 */

/*
 * EX: 1 - 2 - 2 - 2 - 3 - 4 1-3-4 2-3-4 3-4 3-4-2 3-4 2-2-2-2 null null null 2
 * null
 * 
 * if list is null, then do nothing
 * 
 * 
 * 
 * 
 * while (root != null && root.value == target){ root = root.next; } if (root ==
 * null){ return; } else { running = root.next; previous = root; while (running
 * != null){ if (running.value == target){ previous.next = running.next; running
 * = running.next; } } }
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Node {
	public int value;
	public Node next;

	public Node(int value) {
		this.value = value;
		next = null;
	}
}

public class MyLinkedList {
	private Node root;

	public MyLinkedList() {
		root = null;
	}

	private void remove(int target) {
		while (root != null && root.value == target) {
			root = root.next;
		}
		if (root == null) {
			return;
		} else {
			Node running = root.next;
			Node previous = root;
			while (running != null) {
				if (running.value == target) {
					previous.next = running.next;
					running = running.next;
				} else {
					previous = running;
					running = running.next;
				}
			}
		}
	}

	/*
	 * No corner case
	 */
	public void addInFront(int value) {
		Node newNode = new Node(value);
		newNode.next = root;
		root = newNode;

	}

	public void printList() {
		Node temp = root;
		while (temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println("");

	}
	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		l.addInFront(2);
		l.addInFront(3);
		l.addInFront(2);
		l.addInFront(4);
		l.addInFront(2);
		
		l.remove(3);
		l.printList();
		l.remove(2);
		l.printList();
		l.remove(4);
		l.printList();
	}
}
