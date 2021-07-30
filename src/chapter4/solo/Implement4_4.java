package chapter4.solo;

import java.util.Scanner;

public class Implement4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //맵의 크기 N M
        int N = sc.nextInt();
        int M = sc.nextInt();

        //게임 캐릭터가 있는 칸의 좌표 A B, 바라보는 방향 d
        int x = sc.nextInt();
        int y = sc.nextInt();
        int direction = sc.nextInt();

        //북(0), 동(1), 남(2), 서(3)
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};


        int map[][] = new int[N][M];

        //N.M만큼 맵 입력, 0은 육지, 1은 바다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //방문처리
        boolean[][] visited = new boolean[N][M];
        //처음꺼 방문처리
        visited[x][y] = true;

        //방문한 칸수 : count
        int count = 1;
        //회전한 횟수 : turnCount
        int turncount = 0;

        while(true){
            direction = turnLeft(direction);
            System.out.println("direction = " + direction);
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            //왼쪽방향에 아직 가보지 않은 칸이 존재하는 경우
            if(map[nx][ny] == 0 && visited[nx][ny] == false){

                //방문처리
                visited[nx][ny] = true;
                x = nx;
                x = ny;

                //돌은 횟수 0
                turncount = 0;
                //방문값 count 증가
                System.out.println("카운트증가");
                count++;
                continue;
            }else {
                //회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
                turncount++;
            }

            //만약 네 방향 모두 이미 가본 칸이거나 바다로되어 있는 경우
            if (turncount == 4) {

                //바라보는 방향 그대로 유지한채 한칸 뒤로
                nx = x - dx[direction];
                ny = y - dy[direction];

                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }else{
                    break;
                }

                turncount = 0;
            }
        }

        System.out.println("count = " + count);

    }

    //왼쪽으로 회전 함수
    public static int turnLeft(int directin) {
        directin -= 1;
        if (directin == -1) {
            directin = 3;
        }

        return directin;
    }
}
