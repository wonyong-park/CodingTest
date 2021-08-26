package chapter9.boj;

import java.util.Scanner;

public class Solved2224 {
    public static int[][] graph = new int[60][60];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int p = (int)str.charAt(0) - 'A';
            int q = (int)str.charAt(5) - 'A';
            graph[p][q] = 1;
        }

        for (int k = 0; k < graph.length ; k++) {
            for (int a = 0; a < graph.length; a++) {
                for (int b = 0; b < graph.length; b++) {
                    if (graph[a][k] > 0 && graph[k][b] > 0) {
                        graph[a][b] = 1;
                    }
                }
            }
        }

        int count = 0;

        for (int a = 0; a < 60; a++) {
            for (int b = 0; b < 60; b++) {
                if (graph[a][b] == 1 && a != b) {
                    count++;
                }
            }
        }

        System.out.println(count);

        for (int a = 0; a < 60; a++) {
            for (int b = 0; b < 60; b++) {
                if (graph[a][b] == 1 && a != b) {
                    System.out.print((char)(a + 'A'));
                    System.out.print(" => ");
                    System.out.println((char)(b + 'A'));
                }
            }
        }

    }
}

