package chapter9.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved1719 {
    public static int[][] graph;
    public static int[][] minGraph;
    public static final int INF = (int) 1e9;
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        minGraph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a][b] = c;
            graph[b][a] = c;

            minGraph[a][b] = b;
            minGraph[b][a] = a;
        }

        for (int k = 1; k <= n ; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (graph[a][b] > graph[a][k] + graph[k][b]) {
                        graph[a][b] = graph[a][k] + graph[k][b];
                        minGraph[a][b] = minGraph[a][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    System.out.print("- ");
                }else{
                    System.out.print(minGraph[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}
