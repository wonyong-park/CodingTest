package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solved2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        ArrayList<Integer> list = new ArrayList<>();
        int total = 0;
        int f1 = 0;
        int f2 = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
            list.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(total - arr[i] - arr[j] == 100){
                    f1 = arr[i];
                    f2 = arr[j];
                    break;
                }
            }
        }

        list.remove(list.indexOf(f1));
        list.remove(list.indexOf(f2));

        Collections.sort(list);

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
