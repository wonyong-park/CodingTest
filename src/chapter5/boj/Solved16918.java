package chapter5.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solved16918 {
    public static int[][] graph;
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static int R;
    public static int C;
    public static int N;
    public static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[R + 1][C + 1];
        q = new LinkedList<>();

        for (int i = 1; i < R+1; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if(str.charAt(j) == '.'){
                    graph[i][j + 1] = 0;
                }else{
                    graph[i][j + 1] = 1;
                }
            }
        }

        for (int i = 2; i <= N ; i++) {
            if (i % 2 == 0) {
                //폭탄을 전체로 덮는 부분
                setBoom(i);

            }else{
                Booom(i);
            }
        }

        graphPrint();
    }

    private static void Booom(int t) {
        for (int i = 1; i < R+1; i++) {
            for (int j = 1; j < C+1; j++) {
                if (graph[i][j] == t - 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node poll = q.poll();
            int x = poll.getX();
            int y = poll.getY();

            graph[x][y] = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > R || ny < 1 || ny > C) {
                    continue;
                }

                graph[nx][ny] = 0;
            }
        }
    }

    private static void setBoom(int t) {
        for (int i = 1; i < R+1; i++) {
            for (int j = 1; j < C+1; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = t+1;
                }
            }
        }
    }

    private static void graphPrint() {
        for (int i = 1; i < R+1; i++) {
            for (int j = 1; j < C+1; j++) {
                if(graph[i][j] == 0){
                    System.out.print(".");
                }else{
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

}

