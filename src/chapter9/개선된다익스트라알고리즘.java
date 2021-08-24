package chapter9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 개선된다익스트라알고리즘 {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Nodee> pq = new PriorityQueue<>();

        //시작노드의 시작과 거리를 넣는다.
        pq.offer(new Nodee(start, 0));
        d[start] = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print(d[i] + " ");
        }

        while (!pq.isEmpty()) {
            //가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Nodee nodee = pq.poll();
            int dist = nodee.getDistance();
            int now = nodee.getIndex();

            //현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Nodee(graph.get(now).get(i).getIndex(), cost));
                }
            }

            System.out.println();
            for (int i = 1; i <= n; i++) {
                System.out.print(d[i] + " ");
            }
        }
    }
}

class Nodee implements Comparable<Nodee> {
    private int index;
    private int distance;

    public Nodee(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Nodee o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 0;
    }
}