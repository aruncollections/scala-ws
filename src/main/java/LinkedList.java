
public class LinkedList{

    private Node head;

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;

        }
    }

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }


    public Node nthFromLastNode(Node head,int n)
    {
        Node firstPtr=head;
        Node secondPtr=head;

        for (int i = 0; i < n; i++) {
            firstPtr=firstPtr.next;

        }

        while(firstPtr!=null)
        {
            firstPtr=firstPtr.next;
            secondPtr=secondPtr.next;
        }

        return secondPtr;
    }


    public static Node reverseLinkedList(Node node) {
        System.out.println("Now at node " + node.value);
        if (node == null || node.next == null) {
            System.out.println("Last node: " + node.value);
            return node;
        }

        Node remaining = reverseLinkedList(node.next);

        System.out.println();
        System.out.print("rem: ");
        LinkedList.printList(remaining);

        node.next.next = node;
        node.next = null;

        System.out.print("updated rem: ");
        LinkedList.printList(remaining);

        System.out.print("updated node: ");
        LinkedList.printList(node);

        return remaining;
    }

    public static void printList(Node printNode) {
        Node temp = printNode;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public Node findCircular(Node node) {
        Node first = node;
        Node sec = node.next;

        while(first != null || sec != null) {

        }

        return null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Creating a linked list
        Node head=new Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        /*list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));
        list.addToTheLast(new Node(8));
        list.addToTheLast(new Node(9));*/


        list.printList();
        // Finding 3rd node from end
        //Node nthNodeFromLast= list.nthFromLastNode(head,3);
        //System.out.println("3th node from end is : "+ nthNodeFromLast.value);

        list.printList(reverseLinkedList(list.head));
    }


}

