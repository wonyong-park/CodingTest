package chapter5.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solved1260 {


    public static int[][] graph = new int[1001][1001];
    public static boolean[] visited = new boolean[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(start, N);

        visited = new boolean[1001];
        System.out.println();
        bfs(start, N);

    }

    private static void dfs(int x, int max) {

        System.out.print(x + " ");
        visited[x] = true;

        for (int i = 1; i <= max; i++) {
            if(graph[x][i] == 1 && !visited[i]){
                dfs(i, max);
            }
        }

    }

    private static void bfs(int start, int max) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for (int i = 1; i <= max; i++) {
                if (graph[x][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
