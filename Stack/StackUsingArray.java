import java.util.Scanner;

public class StackUsingArray {
    private static int top = -1; // Initialize top to -1
    private static final int MAX_SIZE = 10; // Define stack size
    private static int[] arr = new int[MAX_SIZE]; // Stack array

    public static void overflow() {
        System.out.println("Overflow Condition: Stack is full.");
    }

    public static void underflow() {
        System.out.println("Underflow Condition: Stack is empty.");
    }

    @SuppressWarnings("resource")
    public static void push() {
        if (top == arr.length - 1) {
            overflow();
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the element to insert into the stack: ");
            int element = scanner.nextInt();
            arr[++top] = element; // Increment top and insert element
            System.out.println("Element pushed: " + element);
            
        }

    }

    public static void pop() {
        if (top == -1) {
            underflow();
        } else {
            System.out.println("Element popped: " + arr[top]);
            top--; // Decrement top
        }
    }

    public static void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------");
            System.out.println("1 - Push");
            System.out.println("2 - Pop");
            System.out.println("3 - Display");
            System.out.println("4 - Exit");
            System.out.println("--------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    push();
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
