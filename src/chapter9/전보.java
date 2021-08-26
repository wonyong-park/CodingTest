package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {

    public static int n, m, start;
    public static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    public final static int INF = (int) 1e9;
    public static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(d, INF);

        for (int i = 0; i < m; i++) {
            graph.get(sc.nextInt()).add(new City(sc.nextInt(), sc.nextInt()));
        }

        dijkstra(start);

        int count = 0;
        int max_distance = 0;

        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                count++;
                max_distance = Math.max(max_distance, d[i]);
            }
        }

        System.out.println(count-1 + " " + max_distance);

    }

    private static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            City poll = pq.poll();
            int dist = poll.getDistance();
            int now = poll.getIndex();

            if (d[now] < dist) {
                continue;
            }

            System.out.println("현재 위치 : " + now);
            System.out.println(graph.get(now).size() + " !!");

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new City(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}

class City implements Comparable<City> {
    private int index;
    private int distance;

    public City(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(City o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 0;
    }
}