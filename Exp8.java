
import java.util.Scanner;

class Node {
    int rollNo;
    Node left, right;

    Node(int rollNo) {
        this.rollNo = rollNo;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Insert a roll number
    Node insert(Node root, int rollNo) {
        if (root == null) {
            return new Node(rollNo);
        }

        if (rollNo < root.rollNo) {
            root.left = insert(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = insert(root.right, rollNo);
        } else {
            System.out.println("Roll number already exists!");
        }

        return root;
    }

    // Search for a roll number
    boolean search(Node root, int rollNo) {
        if (root == null) {
            return false;
        }

        if (root.rollNo == rollNo) {
            return true;
        }

        if (rollNo < root.rollNo) {
            return search(root.left, rollNo);
        }

        return search(root.right, rollNo);
    }

    // Find the minimum value in a subtree
    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete a roll number
    Node delete(Node root, int rollNo) {
        if (root == null) {
            return null;
        }

        if (rollNo < root.rollNo) {
            root.left = delete(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = delete(root.right, rollNo);
        } else {
            // Node has no left child
            if (root.left == null) {
                return root.right;
            }

            // Node has no right child
            if (root.right == null) {
                return root.left;
            }

            // Node has two children
            Node successor = findMin(root.right);
            root.rollNo = successor.rollNo;
            root.right = delete(root.right, successor.rollNo);
        }

        return root;
    }

    // Inorder traversal: Left, Root, Right
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.rollNo + " ");
            inorder(root.right);
        }
    }

    // Preorder traversal: Root, Left, Right
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.rollNo + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder traversal: Left, Right, Root
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.rollNo + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int choice, rollNo;

        do {
            System.out.println("\n--- Binary Search Tree ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    rollNo = sc.nextInt();
                    bst.root = bst.insert(bst.root, rollNo);
                    break;

                case 2:
                    System.out.print("Enter roll number to search: ");
                    rollNo = sc.nextInt();

                    if (bst.search(bst.root, rollNo)) {
                        System.out.println("Roll number found.");
                    } else {
                        System.out.println("Roll number not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to delete: ");
                    rollNo = sc.nextInt();

                    if (bst.search(bst.root, rollNo)) {
                        bst.root = bst.delete(bst.root, rollNo);
                        System.out.println("Roll number deleted.");
                    } else {
                        System.out.println("Roll number not found.");
                    }
                    break;

                case 4:
                    System.out.print("Inorder: ");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Preorder: ");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder: ");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}
