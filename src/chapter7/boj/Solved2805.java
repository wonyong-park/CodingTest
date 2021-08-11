package chapter7.boj;

import java.util.Scanner;

public class Solved2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            end = Math.max(arr[i], end);
        }

        int start = 0;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - mid > 0) {
                    total += arr[i] - mid;
                }
            }

            if (total < m) {
                end = mid - 1;
            }else {
                start = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);

    }

}
