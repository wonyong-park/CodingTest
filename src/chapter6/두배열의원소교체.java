package chapter6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 두배열의원소교체 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arrA = new int[N];
        Integer[] arrB = new Integer[N];

        for (int i = 0; i < 5; i++) {
            arrA[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            arrB[i] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            if(arrA[i] < arrB[i]){
                int temp = arrA[i];
                arrA[i] = arrB[i];
                arrB[i] = temp;
            } else break;
        }

        int total = 0;
        for (int i = 0; i < N; i++) {
            total += arrA[i];
        }

        System.out.println("total = " + total);
    }
}
