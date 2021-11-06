package week8;

import java.util.Scanner;

public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int count = 0;
        int n = A.length();
        for (int i = 0; i < n/2; i++) {
            if (A.charAt(i) == A.charAt(n-1-i)) count++;
        }

        if (count == n/2) System.out.println("Yes");
        else System.out.println("No");
    }
}
