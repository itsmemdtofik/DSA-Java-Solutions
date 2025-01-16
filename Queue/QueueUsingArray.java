import java.util.Scanner;

public class QueueUsingArray {
    
    int QUEUE_SIZE = 100;
    int[] queue = new int[QUEUE_SIZE];
    int front = 0;
    int rear = 0;
    @SuppressWarnings("resource")
    public void Enqueue() {
        if (rear == (QUEUE_SIZE - 1)) {
            System.out.println("Queue is full !");
        } else {
            System.out.println("Enter the Element : ");
            Scanner scanner = new Scanner(System.in);
            int data = scanner.nextInt();
            queue[rear++] = data;

        }

    }
    

    public void Dqueue() {
        if (front == rear) {
            System.out.println("Queue is empty !");
        } else {
            System.out.println("Element is deleted = " + queue[front++]);
        }

    }

    public void Display() {
        if (front == rear) {
            System.out.println("Queue is empty !");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println("Queue element is : " + queue[i]);
            }
        }
    }
    

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        QueueUsingArray queueArray = new QueueUsingArray();
        int choice;
        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("1-Insert From Rear");
            System.out.println("2-Delete From Front");
            System.out.println("3-Display");
            System.out.println("4-Exit");
            System.out.println("-------------------------------------\n");
            System.out.println("Enter the choice : ");
           choice = scanner.nextInt();
            System.out.println("-------------------------------------\n");
            switch (choice) {
                case 1:
                    queueArray.Enqueue();
                    break;
                case 2:
                    queueArray.Dqueue();
                    break;
                case 3:
                    queueArray.Display();
                    break;
                case 4:
                    System.out.println("Exitting...!");
                    return;
                default:
                    System.out.println("Invalid Choice !\n\n");
            }
        }

    }

}
