package chapter8.boj;

import java.util.Scanner;

public class Solved2579 {
    public static int[] d = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            arr[i] = sc.nextInt();
        }
        //마지막 전 계단을 밟은 경우
        //d[n] = d[n-3] + arr[n-1] + arr[n]
        //마지막 전 계단을 안밟은 경우
        //d[n] = d[n-2] + arr[n]

        d[1] = arr[1];
        if (n >= 2) {
            d[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(d[i-3] + arr[i - 1] + arr[i], d[i - 2] + arr[i]);
        }

        System.out.println(d[n]);

    }

}
