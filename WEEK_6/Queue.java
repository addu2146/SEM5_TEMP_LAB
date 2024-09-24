import java.util.Scanner;

public class Queue {
    private int SIZE;
    private int front;
    private int back;
    private int[] QueueArray;

    public Queue(int size) {
        this.SIZE = size;
        front = -1;
        back = -1;
        QueueArray = new int[size];
    }

    void enque(int x) {
        if (back == SIZE - 1) {
            System.out.println("Queue full");
        } else {
            if (front == -1) {
                front = 0;
            }
            QueueArray[++back] = x;
            System.out.println("Inserted: " + x);
        }
    }

    void deque() {
        if (front == -1 || front > back) {
            System.out.println("Queue Empty");
        } else {
            System.out.println("Element removed: " + QueueArray[front]);
            front++;
        }
    }

    void peek() {
        if (front == -1 || front > back) {
            System.out.println("Queue Empty");
        } else {
            System.out.println("The front element is: " + QueueArray[front]);
            System.out.println("The back element is: " + QueueArray[back]);
        }
    }

    void Display() {
        if (front == -1 || front > back) {
            System.out.println("Queue empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= back; i++) {
                System.out.print(QueueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1: Enqueue");
            System.out.println("2: Dequeue");
            System.out.println("3: Peek");
            System.out.println("4: Display");
            System.out.println("5: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enque(value);
                    break;
                case 2:
                    queue.deque();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.Display();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
