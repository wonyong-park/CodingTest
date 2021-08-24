package chapter9.solo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 혼자해보는간단다익스트라 {

    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //최단 거리를 담을 배열
    public static int[] d = new int[100001];
    //방문 여부를 담을 배열
    public static boolean[] visited = new boolean[100001];
    //무한을 나타내는 변수
    public static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        System.out.println("n = " + n);
        System.out.println("m = " + m);
        System.out.println("s = " + start);

        //노드의 개수만큼 그래프 생성후 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //간선의 개수만큼 for문
        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int distance = sc.nextInt();
            graph.get(node1).add(new Node(node2, distance));
        }

        //시작에서 처음 d 배열을 무한으로 초기화
        Arrays.fill(d, INF);

        simpleDijksra(start);


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

    private static void simpleDijksra(int start) {
        //시작점을 방문처리와 d[시작점]의 값을 0으로
        d[start] = 0;
        visited[start] = true;

        //시작점과 연결된것들 초기화
        for (int i = 0; i < graph.get(start).size(); i++) {
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }

        //시작점은 처리햇으니 n-1번 반복문
        for (int i = 0; i < n-1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }

    }

    private static int getSmallestNode() {
        int min_value = INF;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }

        return index;
    }
}
