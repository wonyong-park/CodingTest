package chapter5.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solved7576 {
    public static int[][] graph;
    public static Queue<Node> q;
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j + 1] = Integer.parseInt(st.nextToken());
                //익은 토마토를 기록하는 부분
                if (graph[i][j+1] == 1){
                    q.offer(new Node(i,j+1));
                }
            }
        }

        while (!q.isEmpty()) {

            Node getNode = q.poll();
            int x = getNode.getX();
            int y = getNode.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > M) {
                    continue;
                }

                if (graph[nx][ny] != 0) {
                    continue;
                }

                if (graph[nx][ny] == 0 && graph[nx][ny] != -1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if(graph[i][j] == 0){
                    System.out.println("-1");
                    return;
                }
                max = Math.max(graph[i][j], max);
            }
        }
        System.out.println(max - 1);
    }
}

