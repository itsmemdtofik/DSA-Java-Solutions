/**
 * !LinkedList
 */
package List;

import java.util.Scanner;

class SinglyLinkedList {

    // Define the Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // 1. Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Insert at the end
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

    // 3. Insert after a node
    public void insertAfter(int prevData, int data) {
        Node current = head;
        while (current != null && current.data != prevData) {
            current = current.next;
        }
        if (current != null) {
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Node with data " + prevData + " not found.");
        }
    }

    // 4. Delete by value
    public void deleteByValue(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Node with data " + data + " not found.");
        }
    }

    // 5. Delete from the beginning
    public void deleteFromBeginning() {
        if (head != null) {
            head = head.next;
        }
    }

    // 6. Delete from the end
    public void deleteFromEnd() {
        if (head == null)
            return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // 7. Delete after a node
    public void deleteAfter(int prevData) {
        Node current = head;
        while (current != null && current.data != prevData) {
            current = current.next;
        }
        if (current != null && current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("No node found to delete after " + prevData);
        }
    }

    // 8. Search an element
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    // 9. Traverse the list
    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // 10. Reverse the list
    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    // 11. Find the length of the list
    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 12. Find the middle element
    public int findMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (slow != null) ? slow.data : -1;
    }

    // 13. Detect a loop
    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    // 14. Find the intersection of two linked lists (not implemented here in
    // detail)

    // 15. Merge two sorted linked lists
    public static SinglyLinkedList mergeSorted(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
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

    // 16. Remove duplicates
    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // 17. Remove N-th node from the end
    public void removeNthFromEnd(int n) {
        int length = length();
        if (n > length)
            return;
        if (n == length) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 1; i < length - n; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }

    // 18. Get N-th node from the end
    public int getNthFromEnd(int n) {
        int length = length();
        if (n > length)
            return -1;
        Node current = head;
        for (int i = 1; i < length - n; i++) {
            current = current.next;
        }
        return current.data;
    }

    // 19. Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // 20. Get the head node
    public Node getHead() {
        return head;
    }

    // 21. Clear the list
    public void clear() {
        head = null;
    }

    // 22. Clone the list
    public SinglyLinkedList cloneList() {
        SinglyLinkedList clonedList = new SinglyLinkedList();
        Node current = head;
        while (current != null) {
            clonedList.insertAtEnd(current.data);
            current = current.next;
        }
        return clonedList;
    }

    // 23. Swap nodes in pairs
    public void swapPairs() {
        Node current = head;
        while (current != null && current.next != null) {
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
    }

    // 24. Flatten a multi-level linked list (simplified version)
    public void flatten() {
        // This assumes a single level list, for multi-level, further details are
        // required.
    }

    // Main method to drive the operations using switch case
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at the end");
            System.out.println("3. Insert after a node");
            System.out.println("4. Delete by value");
            System.out.println("5. Delete from the beginning");
            System.out.println("6. Delete from the end");
            System.out.println("7. Delete after a node");
            System.out.println("8. Search an element");
            System.out.println("9. Traverse");
            System.out.println("10. Reverse");
            System.out.println("11. Length");
            System.out.println("12. Find middle");
            System.out.println("13. Detect loop");
            System.out.println("14. Merge two sorted lists");
            System.out.println("15. Remove duplicates");
            System.out.println("16. Remove N-th node from the end");
            System.out.println("17. Get N-th node from the end");
            System.out.println("18. Check if empty");
            System.out.println("19. Clear the list");
            System.out.println("20. Clone the list");
            System.out.println("21. Swap pairs");
            System.out.println("22. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    list.insertAtBeginning(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    list.insertAtEnd(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter node to insert after: ");
                    int prev = scanner.nextInt();
                    System.out.print("Enter data: ");
                    list.insertAfter(prev, scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter data to delete: ");
                    list.deleteByValue(scanner.nextInt());
                    break;
                case 5:
                    list.deleteFromBeginning();
                    break;
                case 6:
                    list.deleteFromEnd();
                    break;
                case 7:
                    System.out.print("Enter node to delete after: ");
                    list.deleteAfter(scanner.nextInt());
                    break;
                case 8:
                    System.out.print("Enter data to search: ");
                    System.out.println("Found: " + list.search(scanner.nextInt()));
                    break;
                case 9:
                    list.traverse();
                    break;
                case 10:
                    list.reverse();
                    break;
                case 11:
                    System.out.println("Length: " + list.length());
                    break;
                case 12:
                    System.out.println("Middle: " + list.findMiddle());
                    break;
                case 13:
                    System.out.println("Loop detected: " + list.detectLoop());
                    break;
                case 14:
                    // Implement merging two sorted lists if needed
                    break;
                case 15:
                    list.removeDuplicates();
                    break;
                case 16:
                    System.out.print("Enter N: ");
                    list.removeNthFromEnd(scanner.nextInt());
                    break;
                case 17:
                    System.out.print("Enter N: ");
                    System.out.println("Nth from end: " + list.getNthFromEnd(scanner.nextInt()));
                    break;
                case 18:
                    System.out.println("Is empty: " + list.isEmpty());
                    break;
                case 19:
                    list.clear();
                    break;
                case 20:
                    SinglyLinkedList cloned = list.cloneList();
                    cloned.traverse();
                    break;
                case 21:
                    list.swapPairs();
                    break;
                case 22:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
