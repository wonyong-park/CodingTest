package problem.chpater11;

import java.util.Scanner;

public class 곱하기혹은더하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        long result = input.charAt(0) - '0';

        for (int i = 1; i < input.length(); i++) {
            int temp = input.charAt(i) - '0';
            if (temp <= 1 || result <= 1) {
                result += temp;
            }else{
                result *= temp;
            }
        }

        System.out.println(result);

    }
}
