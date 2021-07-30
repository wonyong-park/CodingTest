package chapter4.boj;

import java.util.Scanner;

public class Solved1913 {
    static int direction = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int val = sc.nextInt();

        int arr[][] = new int[N][N];

        //시작 위치
        int x = N / 2;
        int y = N / 2;
        arr[x][y] = 1;

        //위, 오른쪽, 아래, 왼쪽
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        int count = 1;
        while(true){
            turn_right();
            int nx = -1;
            int ny = -1;
            for (int i = 0; i < count; i++) {
                nx = x + dx[direction];
                ny = y + dy[direction];
                arr[nx][ny] = arr[x][y] + 1;
                x = nx;
                y = ny;
            }

            turn_right();
            for (int i = 0; i < count; i++) {
                nx = x + dx[direction];
                ny = y + dy[direction];
                arr[nx][ny] = arr[x][y] + 1;
                x = nx;
                y = ny;
            }

            count++;
            if(count == N) {
                //끝날때 값
                while(x != 0){
                    x--;
                    arr[x][y] = arr[x + 1][y] + 1;
                }
                break;
            }
        }

        //배열 출력
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
                if(val == arr[i][j]){
                    x = i + 1;
                    y = j + 1;
                }
            }
            System.out.println();
        }

        System.out.println(x + " " + y);

    }

    public static int turn_right() {
        direction++;
        if (direction == 4) {
            direction = 0;
        }

        return direction;
    }
}
