package chapter5.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solved1325 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        ans = new int[N + 1];
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        String[] inputs = new String[2];
        for (int i = 1; i <= M; i++) {
            input = br.readLine();
            inputs = input.split(" ");
            graph.get(Integer.parseInt(inputs[0])).add(Integer.parseInt(inputs[1]));
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, ans[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            if (max == ans[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    ans[y]++;
                }
            }
        }
    }

}

