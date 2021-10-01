import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] a, int number) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - 1) / 2;
            if (a[mid] == number) return mid;
            if (a[mid] > number) {
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        Arrays.sort(arr);

        System.out.println(binarySearch(arr,x));
    }
}
