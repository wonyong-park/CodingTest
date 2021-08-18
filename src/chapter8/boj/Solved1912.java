package chapter8.boj;

import java.util.Scanner;

public class Solved1912 {
    public static int[] d = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n ; i++) {
            d[i] = Math.max(d[i - 1] + arr[i], arr[i]);
            max = Math.max(max, d[i]);
        }

        System.out.println(max);
    }

}
