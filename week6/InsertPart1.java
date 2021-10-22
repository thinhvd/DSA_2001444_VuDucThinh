package week6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.List;
public class InsertPart1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int last = arr.get(n-1);
        for (int i = n-2; i >= 0; i--) {
            if (last >= arr.get(i)) {
                arr.set(i+1, last);
                printArr(arr);
                break;
            }
            arr.set(i+1, arr.get(i));
            printArr(arr);
        }
        if(last < arr.get(0)){
            arr.set(0, last);
            printArr(arr);
        }
    }
    public static void printArr(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        insertionSort1(n, arr);

        bufferedReader.close();
    }
}
