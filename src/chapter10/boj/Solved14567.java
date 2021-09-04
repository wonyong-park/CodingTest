package chapter10.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solved14567 {
    public static int n, m;
    public static int[] indegree = new int[1001];
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
            indegree[b] += 1;
        }

        topologySort();
    }

    private static void topologySort() {
        int[] result = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result[i] = count;
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                //진입 차수를 1 마이너스
                indegree[graph.get(now).get(i)] -= 1;

                if (indegree[graph.get(now).get(i)] == 0) {
                    result[graph.get(now).get(i)] = result[now] + 1;
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
