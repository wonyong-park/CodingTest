package problem.chapter13;

import java.util.*;

public class 경쟁적전염 {

    /**
     * N -> 칸의 크기
     * K -> 1~K 까지의 바이러스의 크기
     * <p>
     * S초 뒤에 X,Y
     */

    public static int arr[][];
    public static int n, k, s, x, y;
    public static List<Position> list;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] != 0) {
                    list.add(new Position(i, j, arr[i][j]));
                }
            }
        }

        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        Collections.sort(list);

        while (s > 0) {
            s--;
            List<Position> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Position now = list.get(i);

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                        arr[nx][ny] = now.virusNumber;
                        temp.add(new Position(nx, ny, arr[nx][ny]));
                    }
                }
            }

            if(temp.size() == 0) break;
            list = temp;
        }

        System.out.println(arr[x-1][y-1]);

    }

}

class Position implements Comparable<Position>{
    int x;
    int y;
    int virusNumber;

    public Position(int x, int y, int virusNumber) {
        this.x = x;
        this.y = y;
        this.virusNumber = virusNumber;
    }

    @Override
    public int compareTo(Position o) {
        return this.virusNumber - o.virusNumber;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", virusNumber=" + virusNumber +
                '}';
    }
}