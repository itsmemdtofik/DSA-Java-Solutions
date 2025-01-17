import java.util.Scanner;

public class TreeTraversal {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	// Method to create the binary tree
	public static Node Create() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Node root = null;
		System.out.print("\nEnter the data: ");
		int data = scanner.nextInt();
		if (data == -1)
			return null;
		root = new Node(data);
		System.out.print("Enter the left child of " + root.data + ": ");
		root.left = Create();
		System.out.print("Enter the right child of " + root.data + ": ");
		root.right = Create();
		return root;
	}

	// Inorder traversal
	static void Inorder(Node root) {
		if (root == null)
			return;
		Inorder(root.left);
		System.out.print(root.data + " -> ");
		Inorder(root.right);
	}

	// Postorder traversal
	static void Postorder(Node root) {
		if (root == null)
			return;
		Postorder(root.left);
		Postorder(root.right);
		System.out.print(root.data + " -> ");
	}

	// Preorder traversal
	static void Preorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " -> ");
		Preorder(root.left);
		Preorder(root.right);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Node root = null; // Declare root here to keep it persistent across different operations.

		while (true) {
			System.out.println("\nSelect the operation:");
			System.out.println("------------------------------");
			System.out.println("1. Create Binary Tree");
			System.out.println("2. Inorder");
			System.out.println("3. Preorder");
			System.out.println("4. Postorder");
			System.out.println("5. Exit");
			System.out.println("------------------------------");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			System.out.println("------------------------------");

			switch (choice) {
				case 1:
					// Create a new tree
					root = Create();
					break;
				case 2:
					// If the tree exists, traverse inorder
					if (root == null) {
						System.out.println("Tree is empty. Please create a tree first.");
					} else {
						System.out.println("\nInorder Traversal:");
						Inorder(root);
						System.out.println(); // Move to the next line after traversal
					}
					break;
				case 3:
					// If the tree exists, traverse preorder
					if (root == null) {
						System.out.println("Tree is empty. Please create a tree first.");
					} else {
						System.out.println("\nPreorder Traversal:");
						Preorder(root);
						System.out.println(); // Move to the next line after traversal
					}
					break;
				case 4:
					// If the tree exists, traverse postorder
					if (root == null) {
						System.out.println("Tree is empty. Please create a tree first.");
					} else {
						System.out.println("\nPostorder Traversal:");
						Postorder(root);
						System.out.println(); // Move to the next line after traversal
					}
					break;
				case 5:
					// Exit the program
					System.out.println("Exiting...");
					scanner.close();
					return;
				default:
					System.out.println("Invalid choice! Please enter a valid option.");
			}
		}
	}
}
