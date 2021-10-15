package week5;

import java.util.Scanner;

public class SimpleTextEditor {

    static class Editor {
        Stack<String> stack = new Stack<>();
        String s = "";

        public void append(String w) {
            s += w;
            stack.push(w);
        }

        public void delete(int k) {
            s = s.substring(0, s.length() - k);
            stack.push(s);
        }

        public void print(int k) {
            System.out.println(s.charAt(k-1));
        }

        public void undo() {
            stack.pop();
            s = stack.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Editor text = new Editor();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                String w = sc.next();
                text.append(w);
            }
            if(type == 2) {
                int K = sc.nextInt();
                text.delete(K);
            }
            if(type == 3) {
                int k = sc.nextInt();
                text.print(k);
            }
            if (type == 4) {
                text.undo();
            }
        }
    }
}
