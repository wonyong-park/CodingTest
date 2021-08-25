package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class 미래도시 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int graph[][] = new int[n + 1][n + 1];
        int INF = (int) 1e9;

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n ; i++) {
            graph[i][i] = 0;
        }

        //연결된 갯수만큼
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();


        for (int index = 1; index <= n; index++) {
            for (int a = 1; a <= n ; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][index] + graph[index][b]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if (distance >= INF) {
            System.out.println("-1");
        }else{
            System.out.println(distance);
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }
}
