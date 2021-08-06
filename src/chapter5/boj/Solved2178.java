package chapter5.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solved2178 {

    public static int[][] graph;
    public static int[][] value;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N;
    public static int M;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        graph = new int[N + 1][M + 1];
        value = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j + 1] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(1, 1));
    }

    private static int bfs(int startX, int startY) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY));

        while (!q.isEmpty()) {
            Node dummy = q.poll();
            int x = dummy.getX();
            int y = dummy.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > M) {
                    continue;
                }

                if (graph[nx][ny] == 0) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return graph[N][M];
    }
}

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
