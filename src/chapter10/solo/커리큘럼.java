package chapter10.solo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 커리큘럼 {

    public static int[] indegree = new int[501];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] times = new int[501];
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            //x는 강의 시간
            int x = sc.nextInt();
            times[i] = x;

            while (true) {
                x = sc.nextInt();
                if(x == -1) break;
                indegree[i] += 1;
                graph.get(x).add(i);

            }
        }

        topologySort();
    }

    private static void topologySort() {
        int[] reuslt = new int[501];
        for (int i = 1; i <= n; i++) {
            reuslt[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                reuslt[graph.get(now).get(i)] = Math.max(reuslt[graph.get(now).get(i)], reuslt[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;

                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(reuslt[i]);
        }
    }
}
