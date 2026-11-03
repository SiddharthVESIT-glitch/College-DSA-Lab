
import java.util.Scanner;

public class Exp11 {

    static int[] temp = new int[100];

    static void mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);

            merge(a, low, mid, high);
        }
    }

    static void merge(int a[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = a[j];
            j++;
            k++;
        }

        for (i = low; i <= high; i++) {
            a[i] = temp[i];
        }
    }

    static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);

            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    static int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        int temp;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;

                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a[] = new int[100];
        int n, choice;

        System.out.print("Enter number of products: ");
        n = sc.nextInt();

        System.out.println("Enter product prices:");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("1. Merge Sort");
        System.out.println("2. Quick Sort");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        if (choice == 1) {
            mergeSort(a, 0, n - 1);
            System.out.println("Using Merge Sort:");
        } 
        else if (choice == 2) {
            quickSort(a, 0, n - 1);
            System.out.println("Using Quick Sort:");
        } 
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        System.out.println("Sorted product prices:");

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}
