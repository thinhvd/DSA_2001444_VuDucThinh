package week10;

import java.util.*;

public class IsThisBinarySearchTree {
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

    boolean checkBST(Node root) {
        return check(root, 0, 10000);
    }

    boolean check(Node root, int min, int max) {
        if (root != null) {
            if (root.data < max && root.data > min) {
                return check(root.left, min, root.data) && check(root.right, root.data, max);
            } else return false;
        }
        return true;
    }
}