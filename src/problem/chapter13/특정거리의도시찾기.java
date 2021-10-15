package problem.chapter13;

import java.util.*;

public class 특정거리의도시찾기 {


    /**
     * N => 도시의 갯수
     * K => 거리 정보
     * X => 출발 도시 정보
     * X에서 출발하여 도달할 수 있는 모든 도시 중에서 최단거리가 정확히 K인 도시의 번호를 출력함
     * M => 도로의 갯수
     * 입력 : N, M, K, X
     */

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[X] = 0;

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(X);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                if (distance[graph.get(now).get(i)] == -1) {
                    distance[graph.get(now).get(i)] = distance[now] + 1;
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        boolean isExist = false;
        for (int i = 1; i < N+1; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                isExist = true;
            }
        }

        if (!isExist) {
            System.out.println("-1");
        }

    }
}
