package chapter9.boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solved13549 {
    public static int n, k;
    public static boolean[] visited = new boolean[100001];
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        PriorityQueue<Coord> pq = new PriorityQueue<Coord>();
        pq.offer(new Coord(n, 0));

        while (!pq.isEmpty()) {
            Coord poll = pq.poll();
            int pos = poll.getPos();
            int count = poll.getCount();

            visited[pos] = true;

            if (pos == k) {
                if (result > count) {
                    result = count;
                }
            }

            if (pos * 2 <= 100000 && !visited[pos * 2]) {
                pq.offer(new Coord(pos * 2, count));
            }

            if (pos + 1 <= 100000 && !visited[pos + 1]) {
                pq.offer(new Coord(pos + 1, count + 1));
            }

            if (pos - 1 >= 0 && !visited[pos - 1]) {
                pq.offer(new Coord(pos - 1, count + 1));
            }

        }
    }

    private static class Coord implements Comparable<Coord>{
        private int pos;
        private int count;

        public Coord(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }

        public int getPos() {
            return pos;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(Coord o) {
            return count - o.count;
        }
    }
}

