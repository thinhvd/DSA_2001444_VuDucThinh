package week10;

import java.util.*;

public class BSTInsertion {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class Solution {

        public static void preOrder(Node root) {
            if (root == null)
                return;

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

        }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

        public static Node insert(Node root, int data) {
            if (root == null) {
                Node node = new Node(data);
                root = node;
            } else if (data < root.data)
                root.left = insert(root.left, data);
            else if (data > root.data)
                root.right = insert(root.right, data);

            return root;
/**
            Node temp = root;
            Node newNode = new Node(data);
            if (root == null) {
                Node node = new Node(data);
                root = node;
            }
            while (temp != null) {
                if (data < temp.data) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        break;
                    }
                    temp = temp.left;
                } else if (data > temp.data) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        break;
                    }
                    temp = temp.right;
                }
            }
            return root;
 */
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            Node root = null;
            while (t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            scan.close();
            preOrder(root);
        }
    }
}
