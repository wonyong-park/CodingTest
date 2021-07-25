package chapter3.boj;

import java.util.Scanner;

public class Solved14916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String input = sc.next();
        sc.nextLine();
        int firstBlueCount = 1;
        int firstRedCount = 1;

        //블루먼저 전체 색칠
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'R'){
                while(true){
                    i++;
                    if(i == input.length() || input.charAt(i) != 'R'){
                        break;
                    }
                }
                firstBlueCount++;
            }
        }

        //래드먼저 전체 색칠
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'B'){
                while(true){
                    i++;
                    if(i == input.length() || input.charAt(i) != 'B'){
                        break;
                    }
                }
                firstRedCount++;
            }
        }
        System.out.println(Math.min(firstRedCount, firstBlueCount));
    }
}