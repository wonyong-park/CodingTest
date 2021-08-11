package chapter7.boj;

import java.util.Scanner;

public class Solved1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        long end = 0;
        int[] arr = new int[k];
        for (int i = 0; i < k ; i++) {
            arr[i] = sc.nextInt();
            end = Math.max(end, arr[i]);
        }

        long start = 1;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;

            for (int i = 0; i < arr.length; i++) {
                total += arr[i] / mid;
            }

            if (total < n) {
                end = mid - 1;
            }else {
                start = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);

    }

}
