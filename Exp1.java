import java.util.Scanner;

public class Exp1{
    static int n=5;
    static int [] stack = new int [n];
    static int top=-1;

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int choice;

        do{
            System.out.println("----stack program----\n"+
            "1.push\n"+
            "2.pop\n"+
            "3.peek\n"+
            "4.display\n"+
            "5.exit");

            choice = sc.nextInt();

            if (choice==1){
                if (top ==n-1){
                    System.out.println("Stack is full");
                }
                else{
                    System.out.println("Enter the element to push");
                    int num = sc.nextInt();
                    top++;
                    stack[top]=num;
                    }
            }
            else if (choice==2){
                if (top==-1){
                    System.out.println("Stack is empty");
                }
                else{
                    System.out.println("Popped element is " + stack[top]);
                    top--;
                }
            }
            else if (choice==3){
                if (top==-1){
                    System.out.println("Stack is empty");
                }
                else{
                    System.out.println("Stack element top num is :" + stack[top]);
                }
            }
            else if (choice==4){
                if (top==-1){
                    System.out.println("Stack is empty");
                }
                else{
                    System.out.println("Stack elements are :");
                    for (int i=0;i<=top;i++){
                        System.out.println(stack[i]);
                    }
                }
            }
            else if (choice==5){
                System.out.println("Exit");  
            }
            else{
                System.out.println("invalid choice");
            } 
        }while(choice!=5);
        sc.close();
    }
}

