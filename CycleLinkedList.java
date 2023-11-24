


import java.util.*;



 class CycleLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    private Node head;

    
    public CycleLinkedList() {
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


    public Node detectCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                // Move one pointer back to the head
                slow = head;

                // Move both pointers at the same pace until they meet at the start of the cycle
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the starting node of the cycle
                return slow;
            }
        }

        // No cycle found
        return null;
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
        CycleLinkedList list = new CycleLinkedList();
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);

        System.out.println("Initial Linked List:");
        list.display();

        list.deleteNode(2);
        System.out.println("Linked List after deleting node with value 2:");
        list.display();



         // Create a cycle by connecting the last node to the second node
        Node lastNode = list.head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = list.head.next;


       

        // Detect and print the starting node of the cycle (2 in this case)
        Node cycleStart = list.detectCycle();
        if (cycleStart != null) {
            System.out.println("Cycle detected. Starting node of the cycle: " + cycleStart.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
    }

