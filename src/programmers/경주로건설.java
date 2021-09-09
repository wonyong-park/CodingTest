package programmers;

import java.util.*;

public class 경주로건설 {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int INF = (int) 1e9;

    public int solution(int[][] board) {
        int n = board.length;
        int answer = INF;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0,0,0));
        pq.add(new Point(0,0,1,0));

        int[][][] visit = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visit[i][j], INF);
            }
        }

        while (!pq.isEmpty()) {
            Point poll = pq.poll();
            if (poll.x == n - 1 && poll.y == n - 1) {
                answer = Math.min(poll.price, answer);
            }

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                int nPrice = poll.price;

                if (i == poll.dir) {
                    nPrice += 100;
                }else{
                    nPrice += 600;
                }

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                    continue;
                }

                if (visit[nx][ny][poll.dir] > nPrice) {
                    visit[nx][ny][poll.dir] = nPrice;
                    pq.add(new Point(nx, ny, i, nPrice));
                }
            }
        }

        return answer;
    }
}

class Point implements Comparable<Point>{
    int x;
    int y;
    int dir;
    int price;

    public Point(int x, int y, int dir, int price) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.price = price;
    }

    @Override
    public int compareTo(Point o) {
        return this.price - o.price;
    }
}




