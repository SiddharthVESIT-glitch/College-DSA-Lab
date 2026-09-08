import java.util.Scanner;

class Patient {
    int patientId;
    String name;
    String emergency;
    Patient next;

   
    Patient(int patientId, String name, String emergency) {
        this.patientId = patientId;
        this.name = name;
        this.emergency = emergency;
        this.next = null;
    }
}

public class Exp6 {

    static Patient top = null;

  
    static void push(int id, String name, String emergency) {
        Patient newPatient = new Patient(id, name, emergency);

        newPatient.next = top;
        top = newPatient;

        System.out.println("Patient record added successfully.");
    }

   
    static void pop() {
        if (top == null) {
            System.out.println("Stack is empty. No patient record available.");
            return;
        }

        System.out.println("\nRemoved Patient:");
        System.out.println("Patient ID: " + top.patientId);
        System.out.println("Name: " + top.name);
        System.out.println("Emergency: " + top.emergency);

        top = top.next;
    }

   
    static void peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\nTop Patient:");
        System.out.println("Patient ID: " + top.patientId);
        System.out.println("Name: " + top.name);
        System.out.println("Emergency: " + top.emergency);
    }

    
    static void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        Patient temp = top;

        System.out.println("\nPatient Records:");

        while (temp != null) {
            System.out.println("Patient ID: " + temp.patientId);
            System.out.println("Name: " + temp.name);
            System.out.println("Emergency: " + temp.emergency);
            System.out.println("-------------------------");

            temp = temp.next;
        }
    }

   
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== HOSPITAL EMERGENCY STACK =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. View Top Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Emergency Details: ");
                    String emergency = sc.nextLine();

                    push(id, name, emergency);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}