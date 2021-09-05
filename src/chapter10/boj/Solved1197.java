package chapter10.boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solved1197 {
    public static int v, e;
    public static int[] parent = new int[10001];
    public static PriorityQueue<Point> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            pq.offer(new Point(a, b, cost));
        }

        for (int i = 1; i <= v ; i++) {
            parent[i] = i;
        }

        long result = 0;
        while (!pq.isEmpty()) {
            Point point = pq.poll();
            int a = point.getNodeA();
            int b = point.getNodeB();

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += point.getCost();
            }
        }

        System.out.println(result);
    }

    private static int findParent(int x) {
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }


}

class Point implements Comparable<Point> {
    private int nodeA;
    private int nodeB;
    private int cost;

    public Point(int nodeA, int nodeB, int cost) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.cost = cost;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Point o) {
        return this.cost - o.cost;
    }
}
