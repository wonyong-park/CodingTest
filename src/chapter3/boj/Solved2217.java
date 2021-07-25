package chapter3.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved2217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] rope = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            rope[i] = sc.nextInt();
        }

        Arrays.sort(rope);
        for (int i = 0; i < rope.length; i++) {
            int val = rope[i] * (rope.length - i);
            if (val > max) {
                max = val;
            }
        }

        System.out.println(max);
    }
}