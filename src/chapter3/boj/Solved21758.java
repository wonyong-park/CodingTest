package chapter3.boj;

import java.util.Scanner;

public class Solved21758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        int[] sum = new int[N];
        int maxTotal = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        //벌 벌 꿀통
        for (int i = 1; i < N-1; i++) {
            maxTotal = Math.max(maxTotal, sum[N - 1] - arr[0] - arr[i] + sum[N - 1] - sum[i]);
        }

        //꿀통 벌 벌
        for (int i = 1; i < N-1; i++) {
            maxTotal = Math.max(maxTotal, sum[N-1] - arr[N-1] - arr[i] + sum[i-1]);
        }

        //벌 꿀통 벌
        for (int i = 1; i < N-1; i++) {
            maxTotal = Math.max(maxTotal, sum[i] - arr[0] + sum[N-1] - sum[i-1] - arr[N-1]);
        }

        System.out.println(maxTotal);
    }
}
