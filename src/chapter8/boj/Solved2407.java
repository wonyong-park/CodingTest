package chapter8.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solved2407 {
    public static BigInteger dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        dp = new BigInteger[101][101];

        dp[1][0] = BigInteger.ONE;
        dp[1][1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i ; j++) {
                if (i == j || j == 0) {
                    dp[i][j] = BigInteger.ONE;
                }else{
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][r]);
    }

}

