package chapter8.boj;

import java.util.Scanner;

public class Solved9095 {
    public static int[] d = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i < 11; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }

    }

}
