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
        if (front == -1) { 
            System.out.println("Queue Empty");
        } else {
            System.out.println("Element removed: " + QueueArray[front]);
            front++; 
        }
    }

   
    void peek() {
        if (front == -1) { 
            System.out.println("Queue Empty");
        } else {
            System.out.println("The front element is: " + QueueArray[front]);
            System.out.println("The back element is: " + QueueArray[back]);
        }
    }
    void Display(){
        if (front==-1){
            System.out.println("Queue empty");
        }
        else{

            for (int j : QueueArray) {
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.deque();
        queue.peek();
        queue.enque(10);
        queue.enque(20);
        queue.enque(30);
        queue.peek();
        queue.deque();
        queue.peek();
        queue.Display();
    }
}
