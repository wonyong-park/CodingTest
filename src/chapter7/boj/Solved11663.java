package chapter7.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solved11663 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(arr, min, max)).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(long[] arr, int min, int max) {

        int start = 0;
        int end = arr.length - 1;
        int left = 0;
        int right = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] < min){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        left = start;

        start = 0;
        end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] > max){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        right = end + 1;

//        System.out.println("left => " + left + "\tright =>" + right + "\t right - left => " + (right - left));

        return right - left;

    }


}
