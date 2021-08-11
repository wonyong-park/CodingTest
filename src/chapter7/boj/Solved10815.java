package chapter7.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved10815 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();

            int start = 0;
            int end = arr.length - 1;
            int result = 0;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (arr[mid] == k) {
                    result = 1;
                    break;
                } else if (arr[mid] < k) {
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

            if (result == 1) {
                sb.append("1 ");
            }else{
                sb.append("0 ");
            }

        }

        System.out.println(sb.toString());

    }

}
