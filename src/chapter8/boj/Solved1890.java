package chapter8.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solved1890 {
    public static int[][] graph;
    public static long[][] dp;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));
    }

    private static long dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == n && y == n) {
            return 1;
        }

        dp[x][y] = 0;

        int dx = x + graph[x][y];
        int dy = y + graph[x][y];

        if (dx > n && dy > n) {
            return 0;
        }

        if (dx <= n) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x + graph[x][y], y));
        }

        if (dy <= n) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x, y + graph[x][y]));
        }

        return dp[x][y];
    }

}
