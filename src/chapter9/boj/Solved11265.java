package chapter9.boj;

import java.util.Scanner;

public class Solved11265 {
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        //플로이드 워샬
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();
            if (graph[start][end] <= dist) {
                System.out.println("Enjoy other party");
            }else{
                System.out.println("Stay here");
            }
        }
    }

}