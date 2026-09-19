import java.util.Scanner;

class LinearQueue{
    private int [] queue;
    private int front,rear,capacity;

    public LinearQueue(int size){
        capacity=size;
        queue=new int[capacity];
        front=-1;
        rear=-1;
    }

    private boolean isFull(){
        return (rear== capacity-1);
    }

    private boolean isEmpty(){
        return (front==-1 || front>rear);
    }

    public void enqueue(int customerid){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        if (front==-1){
            front=0;
        }
        queue[++rear]=customerid;
        System.out.println("Customer "+ customerid+"joined the Queue");
    }

    public void dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Customer "+ queue[front]+" left the Queue");
        front++;

        if (front>rear){
            front=-1;
            rear=-1;
        }
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("Queue os empty");
            return;
        }
        System.out.println("Customer at front of the Queue is "+ queue[front]);
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Queue os empty");
            return;
        }

    for (int i=front;i<=rear;i++){
        System.out.println(queue[i]);
    }
    }
}

public class Exp3{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the Queue");
        int size=sc.nextInt();
        LinearQueue queue=new LinearQueue(size);

        int choice;
        do{
            System.out.println("----Queue program----\n"
            +"1.enqueue\n"
            +"2.dequeue\n"
            +"3.peek\n"
            +"4.display\n"
            +"5.exit");

            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the Customer ID to Queue");
                    int customerid=sc.nextInt();
                    queue.enqueue(customerid);
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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
        sc.close(); 
    }
    
}

