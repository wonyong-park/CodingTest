package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * O(N^2)의 시간복잡도를 가지며, 다익스트라에 의해서 처음 고안되었던 알고리즘이다.
 * V는 노드의 개수
 * 처음에 각 노드에 대한 최단 거리를 담는 1차원 리스트 선언
 * 단계마다 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노들을 선택하기위해 모두 순차탐색해야한다.
 * 따라서 N^2
 */
public class 간단한다익스트라알고리즘 {

    public static final int INF = (int) 1e9; //무한을 나타내는 10억 선언
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라 가정
    public static int n,m, start;

    //각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //방문한 적이 있는지 체크하는 목적의 배열[노드의 개수 + 1]
    public static boolean[] visited = new boolean[100001];
    //최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    //방문하지 않은 노드중에서, 가장 최단 거리가 짧은 노드의 번호를 반환하는 함수
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;// 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            //d[i]가 10억보다 작으면서, 방문하지 않았을때
            //min_value는 d[i], index = i;
            //
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
                System.out.println("i는 : " + i);
            }
        }
        System.out.println("for문 완료!");

        return index;
    }

    //다이스트라 함수
    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;

        //처음에 스타트 지점에서 연결된 노드들을
        //d[시작점과 연결된 노드의 인덱스] = 시작점과 연결된 노드의 인덱스의 값
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        //시작 노드를 제외한 전체 n-1개의 노드에 대해 반복 처리
        for (int i = 0; i < n-1; i++) {
            //현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;

            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

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

}

class Node{

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}
