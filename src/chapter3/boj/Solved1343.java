package chapter3.boj;

import java.util.Scanner;


public class Solved1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.replace('X', 'A');

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '.') {
                continue;
            }

            if(input.charAt(i) == 'A'){
                int countA = 0;
                while(input.charAt(i) == 'A'){
                    countA++;
                    i++;
                    if(i == input.length()) break;
                }

                if(countA %2 == 1){
                    input = "-1";
                    break;
                }

                if(countA %4 == 2){
                    input = input.substring(0, i-2) + "BB" + input.substring(i);
                }
            }

        }

        System.out.println(input);

    }

}
