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
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[x] = 0;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                if (distance[graph.get(now).get(i)] == -1) {
                    distance[graph.get(now).get(i)] = distance[now] + 1;
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        boolean isCheck = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                isCheck = true;
            }
        }

        if (!isCheck) {
            System.out.println("-1");
        }

    }


}
