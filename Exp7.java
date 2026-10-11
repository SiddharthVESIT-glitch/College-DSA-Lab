
import java.util.Scanner;

class CircularSinglyLinkedList {

    static class Node {
        String player;
        Node next;

        Node(String player) {
            this.player = player;
            this.next = null;
        }
    }

    Node head = null;
    Node current = null;

    // Insert a player at the end
    void insert(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
            return;
        }

        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;

        System.out.println(name + " added successfully.");
    }

    // Delete a player by name
    void delete(String name) {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node temp = head;
        Node prev = null;

        do {
            if (temp.player.equalsIgnoreCase(name)) {
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!temp.player.equalsIgnoreCase(name)) {
            System.out.println("Player not found.");
            return;
        }

        // Only one player
        if (temp == head && head.next == head) {
            head = null;
            current = null;
        } else {
            if (temp == head) {
                Node last = head;

                while (last.next != head) {
                    last = last.next;
                }

                head = head.next;
                last.next = head;
            } else {
                prev.next = temp.next;
            }

            if (current == temp) {
                current = temp.next;
            }
        }

        System.out.println(name + " removed successfully.");
    }

    // Display all players
    void traverse() {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node temp = head;

        System.out.println("Players in the circle:");

        do {
            System.out.print(temp.player + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to " + head.player + ")");
    }

    // Move to the next player's turn
    void nextTurn() {
        if (current == null) {
            System.out.println("No players in the game.");
            return;
        }

        System.out.println("Current turn: " + current.player);
        current = current.next;
        System.out.println("Next player's turn: " + current.player);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularSinglyLinkedList list =
                new CircularSinglyLinkedList();

        int choice;

        do {
            System.out.println("\n--- Player Turn Management ---");
            System.out.println("1. Insert Player");
            System.out.println("2. Delete Player");
            System.out.println("3. Display Players");
            System.out.println("4. Next Turn");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String name = sc.nextLine();
                    list.insert(name);
                    break;

                case 2:
                    System.out.print("Enter player to delete: ");
                    String player = sc.nextLine();
                    list.delete(player);
                    break;

                case 3:
                    list.traverse();
                    break;

                case 4:
                    list.nextTurn();
                    break;

                case 5:
                    System.out.println("Game ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
