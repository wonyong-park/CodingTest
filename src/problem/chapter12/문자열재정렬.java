package problem.chapter12;

import java.util.Scanner;

public class 문자열재정렬 {

    public static int[] alpabets = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i) - '0';
            if (temp >= 0 && temp < 10) {
                total += temp;
            }else{
                alpabets[str.charAt(i) - 'A']++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < alpabets.length; i++) {
            for (int j = 0; j < alpabets[i]; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        sb.append(total);

        System.out.println(sb);

    }
}
