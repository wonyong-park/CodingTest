package chapter3.boj;

import java.util.Scanner;

public class Solved11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;

        int[] cost = new int[N];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = sc.nextInt();
        }

        for (int i = cost.length -1; i >= 0; i--) {
            if(K >= cost[i]){
                //개수
                count += K / cost[i];
                //나머지
                K = K % cost[i];
            }
        }

        System.out.println(count);

    }
}
