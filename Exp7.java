
import java.util.Scanner;

class Node {
    int player;
    Node next;

    Node(int player) {
        this.player = player;
        this.next = null;
    }
}

class CircularSinglyLinkedList {
    Node head = null;

    // Insert a player at the end
    void insert(int player) {
        Node newNode = new Node(player);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Delete a player by player number
    void delete(int player) {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node current = head;
        Node previous = null;

        do {
            if (current.player == player) {
                break;
            }

            previous = current;
            current = current.next;
        } while (current != head);

        if (current.player != player) {
            System.out.println("Player not found.");
            return;
        }

        // Only one player exists
        if (current == head && head.next == head) {
            head = null;
        }
        // Deleting the first player
        else if (current == head) {
            Node last = head;

            while (last.next != head) {
                last = last.next;
            }

            head = head.next;
            last.next = head;
        }
        // Deleting any other player
        else {
            previous.next = current.next;
        }

        System.out.println("Player " + player + " deleted.");
    }

    // Display all players once
    void traverse() {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node temp = head;

        System.out.print("Players: ");

        do {
            System.out.print(temp.player + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to first player)");
    }
}

public class Exp7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularSinglyLinkedList list =
                new CircularSinglyLinkedList();

        int choice;
        int player;

        do {
            System.out.println("\n--- Player Turn Management ---");
            System.out.println("1. Insert Player");
            System.out.println("2. Delete Player");
            System.out.println("3. Display Players");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter player number: ");
                    player = sc.nextInt();
                    list.insert(player);
                    System.out.println("Player inserted.");
                    break;

                case 2:
                    System.out.print("Enter player number to delete: ");
                    player = sc.nextInt();
                    list.delete(player);
                    break;

                case 3:
                    list.traverse();
                    break;

                case 4:
                    System.out.println("Game ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
