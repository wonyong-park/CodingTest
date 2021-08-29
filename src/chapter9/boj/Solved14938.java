package chapter9.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved14938 {
    public static int[][] graph;
    public final static int INF = (int) 1e9;
    public static int[] items;
    public static int n, m, r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        items = new int[n + 1];
        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }

        //거리 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n ; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
            graph[b][a] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n ; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] <= m) {
                    sum += items[j];
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }

}
