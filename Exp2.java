public class Exp2 {

    static class Stack {
        private char[] arr;
        private int top;
        private int capacity;

        public Stack(int capacity) {
            this.capacity = capacity;
            this.arr = new char[capacity];
            this.top = -1;
        }

        public void push(char c) {
            if (top == capacity - 1) {
                capacity *= 2;
                char[] newArr = new char[capacity];
                System.arraycopy(arr, 0, newArr, 0, arr.length);
                arr = newArr;
            }
            arr[++top] = c;
        }

        public char pop() {
            if (isEmpty()) {
                return '\0';
            }
            return arr[top--];
        }

        public char peek() {
            if (isEmpty()) {
                return '\0';
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

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

    public static String convertToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack stack = new Stack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ' ') {
                continue;
            }

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
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); 
                }
            }
            else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infixExpr = "A+B*C";
        System.out.println("Infix Expression:   " + infixExpr);
        System.out.println("Postfix Expression: " + convertToPostfix(infixExpr));

        String complexExpr = "(A+B)*C-D/E";
        System.out.println("\nInfix Expression:   " + complexExpr);
        System.out.println("Postfix Expression: " + convertToPostfix(complexExpr));
    }
}