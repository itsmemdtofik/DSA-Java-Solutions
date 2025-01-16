/**
 * 
 * LinkedList Implementation
 * 
 */
package GoldManSachs.Easy;

class SinglyLinkedList<T> {
	private Node<T> head;
	private int size;

	SinglyLinkedList() {
		head = null;
		size = 0;
	}

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	// Add element to the begining of the list.
	public void addFront(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	// Add element to end of linkedlist
	public void addEnd(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		size++;
	}

	// Display all elements
	public void display() throws IllegalStateException {

		if (head == null) {
			throw new IllegalStateException("List is empty!");
		} else {
			Node<T> temp = head;
			while (temp != null) {
				System.out.print(temp.data + " -> ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	// Get the size of the list
	public int size() {
		return size;
	}

	//Remove from begining
	public void removeBegin()throws IllegalStateException{
		if(head == null){
			throw new IllegalStateException("List is empty!");
		}else{
			Node<T> temp = head.next;
			head.next = null;
			head = temp;
		}
		size--;
	}

	//Remove from end
	public void removeEnd() throws IllegalStateException{
		if(head == null){
			throw new IllegalStateException("List is empty!");
		}else{
			Node<T> temp1 = head;
			Node<T> temp2 = head.next;
			while(temp2.next != null){
				temp1 = temp2;
				temp2 = temp2.next;
			}
			temp1.next = null;
		}
		size--;
	}

	public static void main(String[] args) {
		SinglyLinkedList<String> sl = new SinglyLinkedList<String>();

		try {
			sl.addFront("Tofik");
			sl.addEnd("Danish");
			sl.addFront("Haider");
			sl.addEnd("Kiran");

			System.out.println("Linkedlist after adding elements:");
			sl.display();

			/*
			 * System.out.println("Removed from front: " + deque.removeFront());
			 * System.out.println("Removed from rear: " + deque.removeRear());
			 * 
			 * System.out.println("Deque after removals:");
			 * deque.display();
			 * 
			 * System.out.println("Front element: " + deque.getFront());
			 * System.out.println("Rear element: " + deque.getRear());
			 */

			System.out.println("Size of list: " + sl.size());
			sl.removeBegin();
			System.out.println("Linkedlist after deleting elements:");
			sl.display();
			System.out.println("Size of list is : " + sl.size());
			sl.removeEnd();
			System.out.println("Linkedlist after deleting from end elements:");
			sl.display();
			System.out.println("Size of list is : " + sl.size());
		} catch (IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());
		}

		
		/**
		 * * Attempting to remove elements from an empty SinglyLinkedList to demonstrate
		 * * exceptionhandling.
		 */
		try {
			SinglyLinkedList<Integer> emptyDeque = new SinglyLinkedList<>();
			System.out.println("Trying to remove from empty List...");
			emptyDeque.removeBegin(); // This will throw an exception
		} catch (IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}