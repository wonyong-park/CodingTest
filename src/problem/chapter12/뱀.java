package problem.chapter12;

import java.util.*;

public class 뱀 {

    public static int n, k, l;
    public static int[][] arr = new int[101][101];
    public static ArrayList<Node> info = new ArrayList<>();

    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int turn(int direction, char c) {
        if(c == 'L') direction = (direction == 0) ? 3 : direction - 1;
        else direction = (direction + 1) % 4;
        return direction;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        //사과 정보
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }

        System.out.println(simulate());
    }

    private static int simulate() {
        int x = 1, y = 1; //뱀의 머리 위치
        arr[x][y] = 2; //뱀이 처음 존재하는 위치
        int direction = 0; //처음엔 동
        int time = 0 ;// 초 시간
        int index = 0; //다음에 회전할 정보

        //뱀이 차지하고 있는 위치 정보
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            //맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2) {
                //사과가 없다면 이동 후에 꼬리 제거
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }

                //사과가 있다면 이동 후에 그대로 놓기
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            }

            //벽이나 뱀의 몸통과 부딪혔다면
            else{
                time += 1;
                break;
            }

            //다음 위치를 머리로 이동
            x = nx;
            y = ny;
            time += 1;

            //회전할 시간인 경우
            if (index < l && time == info.get(index).getTime()) {
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }

        return time;
    }
}

class Node{
    private int time;
    private char direction;

    public Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return time;
    }

    public char getDirection() {
        return direction;
    }
}

class Position{
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
