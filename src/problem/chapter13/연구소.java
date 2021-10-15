package problem.chapter13;

import java.util.Scanner;

public class 연구소 {
    /**
     * 0은 빈칸, 1은 벽, 2는 바이러스
     * N x M의 크기
     */

    public static int n, m =0;
    public static int result = -1;

    public static int arr[][] = new int[8][8];
    public static int temp[][] = new int[8][8];

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int count) {

        if (count == 3) {
            //원본 배열 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }

            //바이러스 전파
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }
            result = Math.max(result, getResult());
            return;
        }


        //빈 공간에 벽을 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    count += 1;
                    dfs(count);
                    arr[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    private static int getResult() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    count += 1;
                }
            }
        }

        return count;
    }

    private static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    virus(nx,ny);
                }
            }
        }
    }
}
