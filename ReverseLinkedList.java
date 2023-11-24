
import java.util.*;



 class ReverseLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    private Node head;

    
    public ReverseLinkedList() {
        head = null;
    }

   
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + value + " not found in the linked list.");
            return;
        }

        prev.next = current.next;
    }


    public void reverseIterative() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Function to reverse the linked list recursively
    public void reverseRecursive() {
        head = reverseRecursiveHelper(head, null);
    }

    private Node reverseRecursiveHelper(Node current, Node prev) {
        if (current == null) {
            return prev;
        }

        Node next = current.next;
        current.next = prev;
        return reverseRecursiveHelper(next, current);
    }

    
    public void display() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);

        System.out.println("Initial Linked List:");
        list.display();

        list.deleteNode(2);
        System.out.println("Linked List after deleting node with value 2:");
        list.display();


        System.out.println("Initial Linked List:");
        list.display();

        list.reverseIterative();
        System.out.println("Linked List after iterative reversal:");
        list.display();

        list.reverseRecursive();
        System.out.println("Linked List after recursive reversal:");
        list.display();




    }


}
