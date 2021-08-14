package chapter8.boj;

import java.util.Scanner;

public class Solved17626 {
    public static int[] d = new int[50001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            for (int j = 2; j*j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j] + 1);
            }
        }

        System.out.println(d[n]);
    }

}
