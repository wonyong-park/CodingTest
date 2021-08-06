package chapter5.boj;

import java.util.*;

public class Solved2667 {

    public static int[][] graph;
    public static boolean[][] visited;
    public static int N;
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < N ; j++) {
                graph[i][j+1] = str.charAt(j) - '0';
            }
        }


        //그래프 출력
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <=N ; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int k = bfs(i, j);
                if (k != 0) {
                    ans.add(k);
                }
            }
        }

        System.out.println(ans.size());

        Collections.sort(ans);
        for (int k : ans) {
            System.out.println(k);
        }
    }

    private static int bfs(int startX, int startY) {

        if(visited[startX][startY] || graph[startX][startY] == 0) {
//            System.out.print("startX = " + startX);
//            System.out.println("\tstartY = " + startY +" 에서 리턴");
            return 0;
        }

        int count = 1;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > N || graph[nx][ny] == 0)  {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }

        }

        return count;
    }

}

//class Node {
//    private int x;
//    private int y;
//
//    public Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//}
