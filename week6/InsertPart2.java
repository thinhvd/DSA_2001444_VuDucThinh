package week6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class InsertPart2 {
    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for(int i = 0; i < n-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr.get(j) < arr.get(j-1)) {
                    Collections.swap(arr, j, j-1);
                } else break;
            }
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

        insertionSort2(n, arr);

        bufferedReader.close();
    }
}
