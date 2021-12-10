package week13;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Cost implements Comparable<Cost> {
    public int r, v;
    public Cost(int cost, int vertex) {
        r = cost;
        v = vertex;
    }
    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r> c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        return 0;
    }
}
public class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Cost> queue = new PriorityQueue<Cost>();
        ArrayList<ArrayList<Cost>> adj = new ArrayList<ArrayList<Cost>>();

        int n, m, S;
        n = sc.nextInt();
        m = sc.nextInt();

        boolean[] marked = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Cost>());
        }

        for (int i = 0; i < m; i++) {
            int x, y, r;
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            r = sc.nextInt();
            adj.get(x).add(new Cost(r, y));
            adj.get(y).add(new Cost(r, x));
        }
        S = sc.nextInt() - 1;

        int totalWeight = 0;

        queue.add(new Cost(0, S));
        while (queue.size() > 0) {
            Cost c = queue.poll();
            if (!marked[c.v]) {
                for (int i = 0; i < adj.get(c.v).size(); i++) {
                    Cost tmp = adj.get(c.v).get(i);
                    if (!marked[tmp.v]) {
                        queue.add(tmp);
                    }
                }
                totalWeight += c.r;
                marked[c.v] = true;
            }
        }

        System.out.println(totalWeight);
    }
}
