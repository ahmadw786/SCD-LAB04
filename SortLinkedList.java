


import java.util.*;



 class SortLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    private Node head;

    
    public SortLinkedList() {
        head = null;
    }

   

    

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }



     public static SortLinkedList mergeSortedLists(SortLinkedList list1, SortLinkedList list2) {
        SortLinkedList mergedList = new SortLinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.insertAtEnd(current1.data);
                current1 = current1.next;
            } else {
                mergedList.insertAtEnd(current2.data);
                current2 = current2.next;
            }
        }

        // If any elements are left in list1 or list2, append them to the merged list
        while (current1 != null) {
            mergedList.insertAtEnd(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.insertAtEnd(current2.data);
            current2 = current2.next;
        }

        return mergedList;
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
        SortLinkedList list1 = new SortLinkedList();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(3);


        SortLinkedList list2 = new SortLinkedList();
        list2.insertAtEnd(4);
        list2.insertAtEnd(5);
        list2.insertAtEnd(6);

        System.out.println("List 1:");
        list1.display();
        System.out.println("List 2:");
        list2.display();


        SortLinkedList mergedList = mergeSortedLists(list1, list2);
        System.out.println("Merged List:");
        mergedList.display();

        
    }
}
