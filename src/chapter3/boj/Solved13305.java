package chapter3.boj;

import java.util.Scanner;

public class Solved13305 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //거리
        long[] distance = new long[N-1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = sc.nextInt();
        }

        //비용
        long[] cost = new long[N];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = sc.nextInt();
        }

        long minCost = Integer.MAX_VALUE;
        long total = 0;

        for (int i = 0; i < distance.length; i++) {
            //i번째 도시에서 i+1번째 도시까지 움직이는데 최소 비용
            if(cost[i] < minCost){
                minCost = cost[i];
            }

            total += minCost * distance[i];
        }

        System.out.println(total);
    }
}