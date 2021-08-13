package chapter8.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solved2839 {

    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        d = new int[n + 1];
        Arrays.fill(d, 5001);
        d[0] = 0;

        int[] arr = {3, 5};

        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];
            for (int j = k; j <= n; j++) {
                d[j] = Math.min(d[j], d[j - k] + 1);
            }
        }

        if (d[n] == 5001) {
            System.out.println("-1");
        }else{
            System.out.println(d[n]);
        }

    }


}
