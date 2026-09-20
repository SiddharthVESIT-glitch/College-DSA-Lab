import java.util.Scanner;

class CircularQueue{
    private int [] queue;
    private int front,rear,capacity;
    
    public CircularQueue(int size){
        capacity=size;
        queue=new int[capacity];
        front=-1;
        rear=-1;
    }

    private boolean isFull(){
        return ((rear+1)%capacity==front);
    }

    private boolean isEmpty(){
        return (front==-1);
    }

    public void enqueue(int printid){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }

        if (front==-1){
            front=0;
        }
        rear=(rear+1)%capacity;
        queue[rear]=printid;
    }

    public void dequeue(){
        if (isEmpty()){
            System.out.println("Queue os empty");
            return;
        }

        else{
            System.out.println(" dequeued element is: "+queue[front]);
            
            if (front==rear){
                front=-1;
                rear=-1;
            }
            else{
                front=(front+1)%capacity;
            }
        }
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        else{
            System.out.println("The element in front of queue is :"+queue[front]);
        }
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        else{
            System.out.println("The Queue is :");

            int i = front;
            while(true){
                System.out.println(queue[i] + " ");

            if (i == rear) {
                break;
            }
            i=(i+1)%capacity;
            }  
        }
    }
}

    public class Exp4{
    
    public static void main(String[] args){

    Scanner sc=new Scanner (System.in);
    System.out.println("Enter the queue size");
    int capacity=sc.nextInt();
    CircularQueue queue= new CircularQueue(capacity);
    int choice;

    do{
        System.out.println("----Print job queue----\n"
        +"1.enqueue\n"
        +"2.dequeue\n"
        +"3.peek\n"
        +"4.display\n"
        +"5.exit");

        choice=sc.nextInt();

        switch(choice){
            case 1:
                System.out.println("Enter the printid :");
                int job= sc.nextInt();
                queue.enqueue(job);
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
                System.out.println("Exit");
                break;

        }
    }while(choice!=5);
    }
    }