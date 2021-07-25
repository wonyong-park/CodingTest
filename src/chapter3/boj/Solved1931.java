package chapter3.boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solved1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        int minStart = 0;

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(minStart <= arr[i][0]){
                minStart = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
