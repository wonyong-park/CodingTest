package chapter9.boj;

import java.util.Scanner;

public class Solved11403 {
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    if (graph[i][k] > 0 && graph[k][j]>0) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        //그래프 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }
}
