package chapter4.solo;

import java.util.Scanner;

public class Implement4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String dump = i + ""+ j +"" + k + "";
                    System.out.println("dump = " + dump);
                    if(dump.contains("3")) count++;
                }
            }
        }
        System.out.println("count = " + count);
    }
}
