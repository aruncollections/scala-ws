package ds.linkedlist.Q2_02_Return_Kth_To_Last;

import ds.AssortedMethods;

import ds.LinkedListNode;

public class QuestionC {
	public static class Index {
		public int value = 0;
	}	
	
	public static LinkedListNode kthToLast(LinkedListNode head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}
	
	public static LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		LinkedListNode node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;
		if (idx.value == k) {
			return head;
		} 
		return node;
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);

		int i = 1;
		LinkedListNode node = kthToLast(head, i);
        String nodeValue = node == null ? "null" : "" + node.data;
        System.out.println(i + ": " + nodeValue);
	}
}
