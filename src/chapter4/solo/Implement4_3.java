package chapter4.solo;

import java.util.Scanner;

public class Implement4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int row = Integer.parseInt(input.charAt(1) + "");
        int col = (int) input.charAt(0) - 'a' + 1;
        int result = 0;

        int[] drow = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dcol = {-1, 1, -1, 1, -2, 2, -2, 2};

        for (int i = 0; i < drow.length; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow > 0 && ncol > 0 && nrow <= 8 && ncol <= 8) result++;
        }

        System.out.println("result = " + result);
    }
}
