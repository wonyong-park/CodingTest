package chapter10.solo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}

public class 크루스칼알고리즘 {

    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int[] parent = new int[100001];
    public static int v, e;
    public static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 1; i <= v ; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int dist = sc.nextInt();

            edges.add(new Edge(dist, a, b));
        }

        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();

            //사이클이 발생하지 않으면
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(result);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
}
