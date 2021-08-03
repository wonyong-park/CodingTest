package chapter5.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solved2606 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //컴퓨터의 개수
        int N = sc.nextInt();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        //연결된 쌍의 개수
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        System.out.println(bfs(1));

    }

    public static int bfs(int start) {
        int count = -1;
        Queue<Integer> q = new LinkedList<>();

        //시작점을 넣고 방문처리
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            count++;
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    visited[y] = true;
                    q.offer(y);
                }
            }
        }

        return count;
    }
}
