package chapter10.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solved1005 {
    public static int n, k, w;
    public static int[] indegree;
    public static int[] costs;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            k = sc.nextInt();

            indegree = new int[n + 1];
            costs = new int[n + 1];

            graph = new ArrayList<>();
            for (int j = 0; j <= n ; j++) {
                graph.add(new ArrayList<>());
            }

            //비용 입력
            for (int j = 1; j <= n; j++) {
                costs[j] = sc.nextInt();
            }

            //간선 입력
            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(a).add(b);
                indegree[b] += 1;
            }

            //승리하기 위해 건설해야하는 번호
            w = sc.nextInt();

            topologySort();
        }
    }

    private static void topologySort() {
        int[] result = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n ; i++) {
            result[i] = costs[i];

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int k = graph.get(now).get(i);
                result[k] = Math.max(result[k], result[now] + costs[k]);
                indegree[k] -= 1;

                if(indegree[k] == 0) q.offer(k);
            }
        }

        System.out.println(result[w]);

    }
}
