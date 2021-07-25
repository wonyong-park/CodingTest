package chapter3.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solved1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] tips = new int[N];
        int count = 0;
        long total = 0;

        for (int i = 0; i < tips.length; i++) {
            tips[i] = sc.nextInt();
        }
        Arrays.sort(tips);

        //출력 확인
//        for(int tip : tips){
//            System.out.print(tip + " ");
//        }
//        System.out.println();

        for (int i = tips.length-1; i >= 0; i--) {
            if(tips[i] - count > 0){
                total += tips[i] - count;
            }
//            System.out.println("원래 주려던 돈 : " +tips[i] + " 빼는 값 : " + count + " 얻는 팁 : " + (tips[i] - count));
            count++;
        }

        System.out.println(total);
    }
}
