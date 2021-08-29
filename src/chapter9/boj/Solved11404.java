package chapter9.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved11404 {
    public static int[][] graph;
    public static final int INF = (int) 1e9;
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n ; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n ; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(graph[a][b] > c){
                graph[a][b] = c;
            }

        }

        for (int k = 1; k <= n ; k++) {
            for (int a = 1; a <= n ; a++) {
                for (int b = 1; b <= n ; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int a = 1; a <= n ; a++) {
            for (int b = 1; b <= n ; b++) {
                if (graph[a][b] == INF) {
                    System.out.print("0 ");
                }else{
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }

    }
}

