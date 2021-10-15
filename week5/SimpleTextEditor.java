package week5;

import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<String> stack = new Stack<>();
        String s = "";
        stack.push(s);

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                String w = sc.next();
                s += w;
                stack.push(s);
            }
            if(type == 2) {
                int K = sc.nextInt();
                s = s.substring(0, s.length() - K);
                stack.push(s);
            }
            if(type == 3) {
                int k = sc.nextInt();
                System.out.println(s.charAt(k-1));
            }
            if (type == 4) {
                stack.pop();
                s = stack.peek();
            }
        }
    }
}
