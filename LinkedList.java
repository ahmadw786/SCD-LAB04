
import java.util.*;



 class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    private Node head;

    
    public LinkedList() {
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
        LinkedList list = new LinkedList();
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);

        System.out.println("Initial Linked List:");
        list.display();

        list.deleteNode(2);
        System.out.println("Linked List after deleting node with value 2:");
        list.display();
    }
}
