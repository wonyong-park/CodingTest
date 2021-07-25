package chapter3.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved20115 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        float[] energydringks = new float[N];
        double total = 0;

        for (int i = 0; i < energydringks.length; i++) {
            energydringks[i] = sc.nextInt();
        }

        Arrays.sort(energydringks);

        total = energydringks[energydringks.length - 1];

        for (int i = 0; i < energydringks.length-1; i++) {
            total += energydringks[i] / 2;
        }

        System.out.println(total);

    }
}
