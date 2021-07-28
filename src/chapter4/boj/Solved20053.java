package chapter4.boj;

import java.util.Scanner;

public class Solved20053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                int temp = sc.nextInt();
                min = Math.min(min, temp);
                max = Math.max(max, temp);
            }

            System.out.println(min +" " + max);
        }

    }
}
