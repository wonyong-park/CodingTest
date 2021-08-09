package chapter6;

import java.util.Arrays;

public class 계수정렬 {

    public static int MAX_VALUE = 9;

    public static void main(String[] args) {


        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] cnt = new int[MAX_VALUE+1];

        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }

        //결과 출력
        for (int i = 0; i < MAX_VALUE; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }

    }
}
