package week12;

import java.util.*;

public class BFS {
    public class Solution {

        static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
            int[] costs = new int[graph.size()];
            int UNIT_COST = 6;
            for (int i = 0; i < costs.length; ++i) costs[i] = -1;

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            while (!q.isEmpty()) {
                int node = q.poll();
                ArrayList<Integer> tmp = graph.get(node);
                for (int i = 0; i < tmp.size(); i++) {
                    int v = tmp.get(i);
                    if (costs[v] == -1) {
                        q.add(v);
                        if (costs[node] == -1) {
                            costs[v] = costs[node] + UNIT_COST + 1;
                        } else costs[v] = costs[node] + UNIT_COST;
                    }
                }
            }
            return costs;
        }

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scanner = new Scanner(System.in);
            int Q = scanner.nextInt();
            for (int q = 0; q < Q; ++q) {
                int N, M, start;
                N = scanner.nextInt();
                M = scanner.nextInt();
                ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
                for (int i = 0; i <= N; ++i) {
                    graph.add(new ArrayList<Integer>());
                }
                for (int i = 0; i < M; ++i) {
                    int n1, n2;
                    n1 = scanner.nextInt();
                    n2 = scanner.nextInt();
                    graph.get(n1).add(n2);
                    graph.get(n2).add(n1);
                }
                start = scanner.nextInt();

                int[] costs = findShortestReach(graph, start);
                for (int i = 1; i < costs.length; ++i) {
                    if (i == start) continue;
                    System.out.print(costs[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
