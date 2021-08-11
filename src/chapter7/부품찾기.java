package chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class 부품찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] gets = new int[n];
        for (int i = 0; i < gets.length; i++) {
            gets[i] = sc.nextInt();
        }

        sc.nextLine();
        Arrays.sort(gets);

        int m = sc.nextInt();
        sc.nextLine();

        int[] search = new int[m];
        for (int i = 0; i < search.length; i++) {
            search[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < search.length; i++) {
            int target = search[i];
            System.out.println("target => " + target );
            int result = binarySearch(gets, target, 0, gets.length - 1);
            if (result == -1) {
                sb.append("no ");
            }else{
                sb.append("yes ");
            }
        }

        System.out.println(sb.toString());

    }

//    private static int binarySearch(int[] gets, int target, int start, int end) {
//        while (start <= end) {
//            int mid = (start + end) / 2;
//
//            if (gets[mid] == target) {
//                return mid;
//            } else if (gets[mid] > target) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//
//        }
//
//        return -1;
//
//    }

    private static int binarySearch(int[] gets, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end)/2;

        if (gets[mid] == target) {
            return mid;
        }else if(gets[mid] < target){
            return binarySearch(gets, target, mid + 1, end);
        }else{
            return binarySearch(gets, target, start, mid - 1);
        }
    }
}
