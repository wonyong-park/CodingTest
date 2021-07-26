package chapter4.solo;

import java.util.Scanner;

public class Implement4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");

        int x = 1, y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] movetypes = {'L', 'R', 'U', 'D'};

//        System.out.println("N = " + N);
//        for (String plan : plans) {
//            System.out.println("plan = " + plan);
//        }

        for (int i = 0; i < plans.length; i++) {
            int plan = plans[i].charAt(0);
            int nx = x;
            int ny = y;

            for (int j = 0; j < movetypes.length; j++) {
                if(movetypes[j] == plan){
                    nx += dx[j];
                    ny += dy[j];
                }
            }

            if(nx < 1 || ny < 1 || nx > N || ny > N){
                continue;
            }

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);

    }
}
