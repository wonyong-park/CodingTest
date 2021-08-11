package chapter7.boj;

import java.util.Scanner;

public class Solved2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long end = 0;
        int[] arr = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            end = Math.max(end, arr[i]);
            total += arr[i];
        }

        //전체 국가 예산
        int m = sc.nextInt();

        if (m >= total) {
            System.out.println(end);
            return;
        }

        long start = 1;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            total = 0;

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > mid){
                    total += mid;
                }else{
                    total += arr[i];
                }
            }

            if(total > m){
                end = mid - 1;
            }else{
                start = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }

}
