
import java.util.Scanner;

public class Exp9 {
    static int n;
    static int[][] a = new int[10][10];
    static int[] visited = new int[10];
    static int[] queue = new int[10];

    static void BFS(int start) {
        int front = 0, rear = 0;

        visited[start] = 1;
        queue[rear] = start;
        rear++;

        System.out.print("BFS: ");

        while (front < rear) {
            int v = queue[front];
            front++;

            System.out.print(v + " ");

            for (int i = 0; i < n; i++) {
                if (a[v][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue[rear] = i;
                    rear++;
                }
            }
        }
        System.out.println();
    }

    static void DFS(int v) {
        visited[v] = 1;
        System.out.print(v + " ");

        for (int i = 0; i < n; i++) {
            if (a[v][i] == 1 && visited[i] == 0) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting city: ");
        int start = sc.nextInt();

        BFS(start);

        for (int i = 0; i < n; i++) {
            visited[i] = 0;
        }

        System.out.print("DFS: ");
        DFS(start);

        sc.close();
    }
}
