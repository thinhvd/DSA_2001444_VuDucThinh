package week7;

import java.util.Scanner;

public class QuickSortInPlace {
    public static void exch(int[] a ,int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int pivot = a[hi];
        for (int j = lo; j < hi ; j++) {
            if(a[j] <= pivot) {
                exch(a, i, j);
                i++;
            }
        }
        exch(a, i, hi);
        return i;
    }

    public static void quicksort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int p = partition(a, lo, hi);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");

        quicksort(a,lo, p-1);
        quicksort(a,p+1, hi);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quicksort(arr,0, n-1);
    }
}
