package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드워셜알고리즘 {
    public final static int INF = (int) 1e9;
    public static int graph[][] = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            graph[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }
}
