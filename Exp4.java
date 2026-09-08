import java.util.Scanner;

public class Exp4 {

    static final int MAX = 5;
    static int[] queue = new int[MAX];
    static int front = -1;
    static int rear = -1;

    static void enqueue(int value) {
     
        if ((rear + 1) % MAX == front) {
            System.out.println("Queue is Full");
        } else {
          
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % MAX;
            queue[rear] = value;

            System.out.println(value + " added to queue");
        }
    }

    static void dequeue() {
        
        if (front == -1) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println(queue[front] + " removed from queue");

          
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % MAX;
            }
        }
    }

    static void peek() {
        if (front == -1) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Front element is: " + queue[front]);
        }
    }

    static void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue elements are: ");

        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % MAX;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}