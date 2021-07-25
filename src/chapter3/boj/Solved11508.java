package chapter3.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved11508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] costs = new int[N];
        int total = 0;

        for (int i = 0; i < costs.length; i++) {
            costs[i] = sc.nextInt();
        }

        Arrays.sort(costs);

        for (int i = 0; i < costs.length%3; i++) {
            total += costs[i];
        }

        for (int i = costs.length%3; i < costs.length; i+=3) {
            total += costs[i+1] + costs[i+2];
        }

        System.out.println(total);

    }
}

