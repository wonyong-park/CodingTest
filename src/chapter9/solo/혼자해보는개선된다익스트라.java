package chapter9.solo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 혼자해보는개선된다익스트라 {

    public static int n, m, start;
    public static int d[] = new int[100001];
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int newNode = sc.nextInt();
            int nextNode = sc.nextInt();
            int distance = sc.nextInt();
            graph.get(newNode).add(new Node(nextNode, distance));
        }

        //d 배열 초기화
        Arrays.fill(d, INF);

        dijkstar(start);

        for (int i = 1; i <= n ; i++) {
            System.out.print(d[i] + " ");
        }
    }

    private static void dijkstar(int start) {
        //pq에는 index, distance
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
