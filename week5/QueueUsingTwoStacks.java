package week5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingTwoStacks {
    static class Queue {
        static Stack<Integer> stack1 = new Stack<>();
        static Stack<Integer> stack2 = new Stack<>();

        public static void enqueue(int element) {
            stack1.push(element);
        }

        public static int dequeue() {
            if(stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            int x = stack2.pop();
            return x;
        }

        public void print() {
            if(stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            System.out.println(stack2.peek());
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();

        Queue q = new Queue();
        for (int i = 0; i < queries; i++) {
            int type = in.nextInt();
            if (type == 1) {
                int n = in.nextInt();
                q.enqueue(n);
            }
            if(type == 2) {
                q.dequeue();
            }
            if (type == 3) {
                q.print();
            }
        }
    }
}
