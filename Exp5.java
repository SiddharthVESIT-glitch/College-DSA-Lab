import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    Student next;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.next = null;
    }
}

public class Exp5 {
    static Student head = null;

    static void insert(int rollNo, String name) {
        Student newNode = new Student(rollNo, name);

        if (head == null) {
            head = newNode;
        } else {
            Student temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Student inserted successfully.");
    }

   
    static void delete(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

   
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        Student temp = head;

        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

  
    static void search(int rollNo) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found!");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

   
    static void update(int rollNo, String newName) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.name = newName;
                System.out.println("Student record updated successfully.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

   
    static void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Student temp = head;

        System.out.println("\nStudent Registration List:");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo +
                               ", Name: " + temp.name);
            temp = temp.next;
        }
    }

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Registration System =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    insert(rollNo, name);
                    break;

                case 2:
                    System.out.print("Enter Roll No to delete: ");
                    rollNo = sc.nextInt();

                    delete(rollNo);
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    rollNo = sc.nextInt();

                    search(rollNo);
                    break;

                case 4:
                    System.out.print("Enter Roll No to update: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    update(rollNo, newName);
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}