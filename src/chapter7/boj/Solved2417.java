package chapter7.boj;

import java.util.Scanner;

public class Solved2417 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long start = 0;
        long result = 0;
        long end = s;

        while (start <= end) {

            long mid = (start + end) / 2;

            if(mid < Math.sqrt(s)){
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}
