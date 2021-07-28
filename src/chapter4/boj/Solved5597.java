package chapter4.boj;

import java.util.Scanner;

public class Solved5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] checks = new boolean[30];

        for (int i = 0; i < 28; i++) {
            checks[sc.nextInt() - 1] = true;
        }

        for (int i = 0; i < checks.length; i++) {
            if(checks[i] == false) System.out.println(i + 1);
        }
    }
}

