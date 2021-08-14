package chapter8.boj;

import java.util.Scanner;

public class Solved1010 {

    public static int d[][] = new int[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < 30; i++) {
            d[i][i] = 1;
            d[i][0] = 1;
        }

        for (int i = 1; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                if(i == j) continue;
                d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
            }
        }

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(d[m][n]);
        }
    }

    /*
    private static int combination(int m, int n) {

        if (d[m][n] > 0) {
            return d[m][n];
        }

        if (n == m || n == 0) {
            d[m][n] = 1;
            return d[m][n];
        }

        return combination(m - 1, n - 1) + combination(m - 1, n);
    }
     */

}
