package week8;

import java.util.*;

public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        int N = a.size();
        Queue<Integer> maxPQ = new PriorityQueue(N / 2 + 1, Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue(N / 2 + 1);
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (!maxPQ.isEmpty() && a.get(i) < maxPQ.peek()) {
                maxPQ.add(a.get(i));
            } else {
                minPQ.add(a.get(i));
            }

            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.remove());
            } else if (minPQ.size() > maxPQ.size() + 1) {
                maxPQ.add(minPQ.remove());
            }
            double median;
            if (minPQ.size() == maxPQ.size()) {
                median = (minPQ.peek() + maxPQ.peek()) * 0.5;
            }
            else if (minPQ.size() > maxPQ.size()) median = minPQ.peek();
            else median = maxPQ.peek();

            result.add(median);
        }

        return result;
    }
}
