import java.util.Scanner;
import java.util.Stack;

public class Exp2 {

    private static int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } 
            else if (c == '(') {
                stack.push(c);
            } 
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); 
            } 
            else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression (Mismatched Parentheses)";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String expression = "";

        do {
            System.out.println("\n--- Scientific Calculator: Infix to Postfix ---");
            System.out.println("1. Enter Infix Expression");
            System.out.println("2. Convert to Postfix");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Infix Expression (e.g., A+B*C): ");
                    expression = scanner.nextLine();
                 
                    expression = expression.replaceAll("\\s+", ""); 
                    System.out.println("Expression saved.");
                    break;
                case 2:
                    if (expression.isEmpty()) {
                        System.out.println("Error: Please enter an expression first (Option 1).");
                    } else {
                        String postfix = infixToPostfix(expression);
                        System.out.println("Infix Expression : " + expression);
                        System.out.println("Postfix Result   : " + postfix);
                    }
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
