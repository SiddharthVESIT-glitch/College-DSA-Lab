
import java.util.Scanner;

public class Exp10 {

    static void selectionSort(int a[], int n) {
        int i, j, min, temp;

        for (i = 0; i < n - 1; i++) {
            min = i;

            for (j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    static void insertionSort(int a[], int n) {
        int i, j, key;

        for (i = 1; i < n; i++) {
            key = a[i];
            j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a[] = new int[10];
        int n, choice;

        System.out.print("Enter number of students: ");
        n = sc.nextInt();

        System.out.println("Enter student marks:");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("1. Selection Sort");
        System.out.println("2. Insertion Sort");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        if (choice == 1) {
            selectionSort(a, n);
            System.out.println("Using Selection Sort:");
        } 
        else if (choice == 2) {
            insertionSort(a, n);
            System.out.println("Using Insertion Sort:");
        } 
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        System.out.println("Sorted marks:");

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}
