package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬 {

    //노드의 개수 v, 간선의 개수 e, 노드의 개수는 최대 1000
    public static int v,e;
    //모든 노드에 대한 진입차수는 0으로 초기화
    public static int[] indegree = new int[100001];
    //각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    //위상 정렬 함수
    public static void topologySort() {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        //처음 시작할때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= v ; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;

                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i <= v ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b] += 1;
        }

        topologySort();
    }
}
