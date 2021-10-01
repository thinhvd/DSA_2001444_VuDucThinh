import edu.princeton.cs.algs4.In;

public class ThreeSum {
    public static void sortArr (int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length - 1; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    public static void findTriplet(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1 ;
            int temp = a[i];
            while (l < r) {
                if (temp + a[l] + a[r] == 0) {
                    System.out.println(temp + " " + a[l] + " " + a[r]);
                    break;
                }
                if (temp + a[l] + a[r] > 0) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }
    }
    public static void main(String[] args) {
        In in = new In("D:\\DSA\\Coursera\\algs4-data\\4Kints.txt");
        int[] a = in.readAllInts();

        sortArr(a);
        findTriplet(a);
    }
}
