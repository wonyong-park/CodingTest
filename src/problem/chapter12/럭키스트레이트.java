package problem.chapter12;

import java.util.Scanner;

public class 럭키스트레이트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int sum = 0;
        for (int i = 0; i < str.length()/2; i++) {
            sum += Integer.parseInt(str.charAt(i) + "");
            sum -= Integer.parseInt(str.charAt(str.length() / 2 + i) + "");
        }

        if (sum == 0) {
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }

    }
    //1
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = String.valueOf(n);

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length()/2; i++) {
            left += Integer.parseInt(s.charAt(i) + "");
            right += Integer.parseInt(s.charAt(s.length() / 2 + i) + "");
        }

        if (left == right) {
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }

    }
     */
}
