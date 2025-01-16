package GoldManSachs.Easy;

/**
 * !Dequeue
 * 
 * The implementation of a Deque (Double-Ended Queue) I provided is based on a
 * Doubly Linked List,
 * as it uses nodes that have two pointers: one pointing to the next node and t
 * he other pointing to the previous node. This allows for efficient insertion
 * and removal of elements from both ends of the deque.
 * 
 * *Operations:
 * addFront(), addRear(), removeFront(), and removeRear()
 * size(), getFirst(), getRear().
 * 
 */

public class Dqueue {

	Node front;
	Node rear;
	int size;

	Dqueue() {
		front = null;
		rear = null;
		size = 0;
	}

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	/**
	 * *Add an element to the front of the Dqueue
	 * 
	 * @param args
	 */
	public void addFront(int data) {
		Node newNode = new Node(data);
		if (front == null) {
			front = newNode;
			rear = newNode;
		} else {
			newNode.next = front;
			front.prev = newNode;
			front = newNode;
		}
		size++;
	}

	/**
	 * *Add an element to the end of the Dqueue
	 * 
	 * @param data
	 */
	public void addRear(int data) {
		Node newNode = new Node(data);
		if (rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			newNode.prev = rear;
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}

	/**
	 * *Remove an element from the front of Dqueue
	 * 
	 * @return
	 */
	public int removeFront() throws IllegalStateException {

		if (front == null) {
			throw new IllegalStateException("Dqueue is empty");
		}

		int data = front.data;

		front = front.next;
		if (front == null) {
			rear = null; // Dqueue is empty after removal.
		} else {
			front.prev = null;
		}
		size--;
		return data;
	}

	/**
	 * *Remove an element from the rear of the Dqueue
	 * 
	 * @return
	 */
	public int removeRear() {
		if (rear == null) {
			throw new IllegalStateException("Dqueue is empty");
		}
		int data = rear.data;
		rear = rear.prev;
		if (rear == null) {
			front = null; // Dqueue is empty after removal
		} else {
			rear.next = null;
		}
		size--;

		return data;
	}

	/**
	 * *Get the element from the Dqueue without removing
	 * 
	 * @return
	 */
	public int getFront() throws IllegalStateException {
		if (front == null) {
			throw new IllegalStateException("Dqueue is empty");
		}

		return front.data;
	}

	/**
	 * *Get en element from the rear of the Dqueue without removing it
	 * 
	 * @return
	 */
	public int getRear() throws IllegalStateException {
		if (rear == null) {
			throw new IllegalStateException("Dqueue is empty");
		}
		return rear.data;
	}

	/**
	 * *Get the size of Dqueue
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * *Get the size of Dqueue
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * * Display element of the queue
	 */
	public void display() {
		if (front == null) {
			System.out.println("Dqueue is empty");
			return;
		}

		Node temp = front;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * PeakFirst()
	 * 
	 * @param args
	 */

	public Integer peakFirst() {
		if (front == null) {
			return null;
		}
		return (Integer) front.data;
	}

	/**
	 * peakLast()
	 * 
	 * @param args
	 */
	public Integer peakLast() throws IllegalStateException {

		return (rear == null ? null : rear.data);
	}

	public static void main(String[] args) {

		Dqueue deque = new Dqueue();

		try {
			deque.addRear(10);
			deque.addRear(20);
			deque.addFront(5);
			deque.addFront(2);

			System.out.println("Deque after adding elements:");
			deque.display();

			System.out.println("Removed from front: " + deque.removeFront());
			System.out.println("Removed from rear: " + deque.removeRear());

			System.out.println("Deque after removals:");
			deque.display();

			System.out.println("Front element: " + deque.getFront());
			System.out.println("Rear element: " + deque.getRear());
			deque.removeFront();
			deque.removeFront();
			System.out.println("Peak First element: " + deque.peakFirst());
			System.out.println("Peak Rear element: " + deque.peakLast());

			System.out.println("Size of Deque: " + deque.size());
		} catch (IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Attempting to remove elements from an empty Deque to demonstrate exception
		// handling
		/**
		 * * Attempting to remove elements from an empty Deque to demonstrate
		 * * exceptionhandling.
		 */
		try {
			Dqueue emptyDeque = new Dqueue();
			System.out.println("Trying to remove from empty Deque...");
			emptyDeque.removeFront(); // This will throw an exception
		} catch (IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
