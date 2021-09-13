package problem.chpater11;

import java.util.Scanner;

public class 문자열뒤집기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int count0 = 0;
        int count1 = 0;

        if (input.charAt(0) == '0') {
            count1++;
        }else{
            count0++;
        }

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) != input.charAt(i)) {
                //0에서 1로 바뀌는 경우
                if (input.charAt(i) == '1') {
                    count0++;
                }else{
                    count1++;
                }
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
