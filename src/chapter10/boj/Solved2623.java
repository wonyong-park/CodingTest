package chapter10.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solved2623 {
    public static int n, m;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] indegree = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int count = sc.nextInt();
            int[] arr = new int[count];
            for (int j = 0; j < count; j++) {
                arr[j] = sc.nextInt();
            }

            for (int j = 0; j < count-1; j++) {
                int a = arr[j];
                int b = arr[j + 1];

                graph.get(a).add(b);
                indegree[b]++;
            }
        }

        topologySort();
    }

    private static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;

                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        if (result.size() == n) {
            for (int k : result) {
                System.out.println(k);
            }
        }else{
            System.out.println("0");
        }
    }
}

