package chapter7.boj;

import java.util.Scanner;

public class Solved1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long start = 1;
        long result = 0;
        long end = s;

        while (start <= end) {

            long mid = (start + end) / 2;
            long total = (mid * (mid + 1))/2;

            //토탈이 더 큰경우
            //end 범위를 줄여줘야함
            if(total > s){
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);

    }
}
