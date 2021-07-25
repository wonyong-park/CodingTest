package chapter3.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved20300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] loss = new long[N];
        long minLoss = 0;
        for (int i = 0; i < loss.length; i++) {
            loss[i] = sc.nextLong();
        }

        Arrays.sort(loss);

        //짝수 일때
        if(loss.length%2 == 0){
            for (int i = 0; i < loss.length/2; i++) {
                long sum = loss[i] + loss[loss.length - i - 1];
                if(sum > minLoss) minLoss = sum;
            }
        }else{
            minLoss = loss[loss.length - 1];
            for (int i = 0; i < loss.length/2; i++) {
                long sum = loss[i] + loss[loss.length - i - 2];
                if(sum > minLoss) minLoss = sum;
            }
        }
        System.out.println(minLoss);
    }
}
