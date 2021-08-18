package chapter8.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solved9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] d = new int[2][n+1];

            //첫번째 입력줄
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
            }

            //두번쨰 입력줄
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[1][j] = Integer.parseInt(st.nextToken());
            }

            d[0][1] = arr[0][1];
            d[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                d[0][j] = Math.max(d[1][j - 1], d[1][j - 2]) + arr[0][j];
                d[1][j] = Math.max(d[0][j - 1], d[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(d[0][n], d[1][n]));

        }

    }
}

