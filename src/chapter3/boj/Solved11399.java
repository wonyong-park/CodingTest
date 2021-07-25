package chapter3.boj;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solved11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] orders = new int[N];
        int total = 0;

        for (int i = 0; i < orders.length; i++) {
            orders[i] = sc.nextInt();
        }

        Arrays.sort(orders);
        total = orders[0];

        for (int i = 1; i < orders.length; i++) {
            total += orders[i] + orders[i-1];
            orders[i] += orders[i-1];
        }

        System.out.println(total);

    }
}
