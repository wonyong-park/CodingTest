package chapter5.solo;

import java.util.Scanner;

public class 음료수얼려먹기 {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        //모든 위ㅑ치에 대해 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(i,j)) result += 1;
            }
        }
        System.out.println("result = " + result);
    }

    public static boolean dfs(int x, int y) {

        //주어진 범위를 벗어나는 경우 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }

        //해당 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {

            System.out.println("x = " + x + "\ty = " + y);
            //해당 노드를 방문 처리 후
            graph[x][y] = 1;

            //상,하,좌,우 를 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}
