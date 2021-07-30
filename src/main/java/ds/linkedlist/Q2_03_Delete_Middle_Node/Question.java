package ds.linkedlist.Q2_03_Delete_Middle_Node;

import ds.LinkedListNode;
import ds.AssortedMethods;

public class Question {

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}

		System.out.println("Middle node: " + n.data);
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}

}
