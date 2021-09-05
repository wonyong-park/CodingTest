package chapter10.boj;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solved1766 {
    public static int n, m;
    public static int[] indegree = new int[32001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            indegree[b]++;
        }

        topolgySort();

    }

    private static void topolgySort() {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            result.add(now);
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;

                if (indegree[graph.get(now).get(i)] == 0) {
                    pq.offer(graph.get(now).get(i));
                }
            }
        }

        for (int k :result) {
            System.out.print(k + " ");
        }



    }
}
