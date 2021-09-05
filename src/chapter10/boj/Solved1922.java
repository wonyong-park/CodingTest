package chapter10.boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solved1922 {
    public static int n,m;
    public static int[] parent = new int[1001];

    public static void main(String[] args) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            pq.offer(new Computer(a, b, cost));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            Computer now = pq.poll();
            int comA = now.getComA();
            int comB = now.getComB();

            if (findParent(comA) != findParent(comB)) {
                unionParent(comA, comB);
                result += now.getCost();
            }

        }

        System.out.println(result);
    }

    public static int findParent(int x) {
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }
}

class Computer implements Comparable<Computer> {
    private int comA;
    private int comB;
    private int cost;

    public Computer(int comA, int comB, int cost) {
        this.comA = comA;
        this.comB = comB;
        this.cost = cost;
    }

    public int getComA() {
        return comA;
    }

    public int getComB() {
        return comB;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Computer o) {
        return this.cost - o.cost;
    }
}