import edu.princeton.cs.algs4.*;

public class TwoSum {
    public static void findDouble (int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i] + a[j] == 0) System.out.println(a[i] + " " + a[j]);
            }
        }
    }
    public static void main(String[] args) {
        In in = new In("D:\\DSA\\Coursera\\algs4-data\\4kints.txt");
        int[] a = in.readAllInts();

        findDouble(a);
    }
}
