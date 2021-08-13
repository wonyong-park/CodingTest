package chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class 효율적인화폐구성 {

    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        d = new int[m+1];
        Arrays.fill(d, 10001);
        d[0] = 0;

        int[] arr = new int[n];
        for (int i = 0; i <arr.length; i++) {
            arr[i] = sc.nextInt();
        }


        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];

            for (int j = k; j < d.length; j++) {
                //화폐 만드는 방법이 존재하는 경우
                if (d[j - k] != 10001) {
                    d[j] = Math.min(d[j], d[j - k] + 1);
                }
            }
        }

        if (d[m] == 10001) {
            System.out.println("-1");
        }else{
            System.out.println(d[m]);
        }


    }
}
