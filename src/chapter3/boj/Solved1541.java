package chapter3.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        boolean minus = false;
        String input = sc.nextLine();
        String[] inputArr = input.split("-");

        if(inputArr[0].contains("+")){
            String[] dummy = inputArr[0].split("\\+");
            for (String s : dummy) {
                result += Integer.parseInt(s);
            }
        }else{
            result = Integer.parseInt(inputArr[0]);
        }


        for (int i = 1; i < inputArr.length; i++) {

            if(inputArr[i].contains("+")){
                String[] dummy = inputArr[i].split("\\+");
                for (String s : dummy) {
                    result -= Integer.parseInt(s);
                }
            }else{
                result -= Integer.parseInt(inputArr[i]);
            }
        }

        System.out.println(result);


    }
}
