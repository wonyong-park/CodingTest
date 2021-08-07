package chapter5.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solved7569 {

    public static int[][][] graph;
    public static Queue<Tomato> q;
    public static int dz[] = {0, 0, 0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0, 0, 0};
    public static int dy[] = {0, 0, -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        graph = new int[H + 1][N + 1][M + 1];
        q = new LinkedList<>();

        for (int i = 1; i < H + 1; i++) { //h
            for (int j = 1; j < N + 1; j++) { //N
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) { // m
                    graph[i][j][k + 1] = Integer.parseInt(st.nextToken());
                    if(graph[i][j][k+1] == 1){
                        q.offer(new Tomato(j, k+1, i));
                    }
                }
            }
        }

        while (!q.isEmpty()) {

            Tomato getTomato = q.poll();
            int x = getTomato.getX();
            int y = getTomato.getY();
            int z = getTomato.getZ();

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > M || nz < 1 || nz > H) {
                    continue;
                }

                if (graph[nz][nx][ny] != 0) {
                    continue;
                }

                if (graph[nz][nx][ny] == 0 && graph[nz][nx][ny] != -1) {
                    graph[nz][nx][ny] = graph[z][x][y] + 1;
                    q.offer(new Tomato(nx, ny, nz));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < H + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 0; k < M; k++) {
                    if(graph[i][j][k + 1] == 0){
                        System.out.println("-1");
                        return;
                    }
                    max = Math.max(graph[i][j][k + 1], max);
                }
            }
        }

        System.out.println(max-1);
    }

}

class Tomato {
    private int x;
    private int y;
    private int z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
