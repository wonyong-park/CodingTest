package chapter8.boj;

import java.util.Scanner;

public class Solved11053 {
    public static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            d[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(d[i], max);
        }

        System.out.println(max);

    }

}
