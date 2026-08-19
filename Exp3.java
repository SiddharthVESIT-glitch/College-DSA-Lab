import java.util.Scanner;

class LinearQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public LinearQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    public void enqueue(int customerId) {
        if (isFull()) {
            System.out.println("Queue is Full! Cannot add more customers right now.");
            return;
        }
        
        if (front == -1) {
            front = 0;
        }
        
        queue[++rear] = customerId;
        System.out.println("Customer ID " + customerId + " joined the queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! No customers to serve.");
            return;
        }
        
        System.out.println("Customer ID " + queue[front] + " has been served and left the counter.");
        front++;
        
        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! No one is at the front.");
            return;
        }
        System.out.println("Next customer to be served: Customer ID " + queue[front]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        
        System.out.print("Current Line (Front to Rear): ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Exp3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the maximum capacity of the reservation counter line: ");
        int size = scanner.nextInt();
        
        LinearQueue queue = new LinearQueue(size);
        int choice;
        
        do {
            System.out.println("\n--- Railway Ticket Reservation Counter ---");
            System.out.println("1. Enqueue (New customer joins)");
            System.out.println("2. Dequeue (Serve customer at the front)");
            System.out.println("3. Peek (Check who is next)");
            System.out.println("4. Display current line");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID / Ticket Number: ");
                    int customerId = scanner.nextInt();
                    queue.enqueue(customerId);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Closing the reservation counter. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 5.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
