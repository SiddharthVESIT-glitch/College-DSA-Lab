import java.util.Scanner;

public class Exp1 {
    
    static int[] stack = new int[5];
    static int top = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------ Simple Stack Program ------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            if (choice == 1) {
                if (top == 4) { 
                    System.out.println("Stack is Full (Overflow)");
                } 
                else {
                    System.out.print("Enter a number to push: ");
                    int num = sc.nextInt();
                    top++;
                    stack[top] = num;
                    System.out.println(num + " added to stack.");
                }
                
            } 
            else if (choice == 2) {
                if (top == -1) {
                    System.out.println("Stack is Empty (Underflow)");
                } 
                else {
                    System.out.println("Popped: " + stack[top]);
                    top--;
                }
                
            } 
            else if (choice == 3) {
                if (top == -1) {
                    System.out.println("Stack is Empty");
                } 
                else {
                    System.out.println("Top element is: " + stack[top]);
                }
                
            } 
            else if (choice == 4) {
                if (top == -1) {
                    System.out.println("Stack is Empty");
                } 
                else {
                    System.out.print("Stack elements: ");
                    for (int i = 0; i <= top; i++) {
                        System.out.print(stack[i] + " ");
                    }
                    System.out.println();
                }
                
            } 
            else if (choice == 5) {
                System.out.println("Exit");
            } 
            else {
                System.out.println("Invalid choice");
            }

        } while (choice != 5);
        
        sc.close();
    }
}