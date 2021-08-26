package chapter9.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solved18352 {

    public static int n, m, k, start;
    public static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    public final static int INF = (int) 1e9;
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        d = new int[n + 1];

        Arrays.fill(d, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new City(b, 1));
        }

        dijkstra(start);


        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if(d[i] == k){
                result.add(i);
            }
        }


        if (result.size() == 0) {
            System.out.println("-1");
        }else{
            for (Integer integer : result) {
                System.out.println(integer);
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            City poll = pq.poll();
            int dist = poll.getDistacne();
            int now = poll.getIndex();

            if (d[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist + graph.get(now).get(i).getDistacne();
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
    private int distacne;

    @Override
    public int compareTo(City o) {
        return this.distacne - o.distacne;
    }

    public City(int index, int distacne) {
        this.index = index;
        this.distacne = distacne;
    }

    public int getIndex() {
        return index;
    }

    public int getDistacne() {
        return distacne;
    }
}

