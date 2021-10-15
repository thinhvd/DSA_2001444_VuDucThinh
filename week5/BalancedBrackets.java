package week5;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        char[] brackets =  s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < brackets.length; i++) {
            char c = brackets[i];
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()){
                return "NO";
            }

            char p = stack.pop();
            if (c == '}' && p != '{' || c == ']' && p != '[' || c == ')' && p != '(') {
                return "NO";
            }
        }
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }
}
