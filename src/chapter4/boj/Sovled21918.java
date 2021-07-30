package chapter4.boj;

import java.util.Scanner;

public class Sovled21918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //전구의 개수 N
        int N = sc.nextInt();
        //명령어의 개수 M
        int M = sc.nextInt();

        //전구 N개가 어떤 상태인지
        int[] status = new int[N];
        for (int i = 0; i < N; i++) {
            status[i] = sc.nextInt();
        }

        //a는 a번째 명령어
        //bc는 명령어 후 위치
        for (int i = 0; i < M; i++) {
            int sel = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();

            if(sel == 1){
                status[start - 1] = end;
            } else if (sel == 2) {
                for (int j = start-1; j < end; j++) {
                    if(status[j] == 1){
                        status[j] = 0;
                    }else{
                        status[j] = 1;
                    }
                }
            } else if (sel == 3) {
                for (int j = start-1; j < end; j++) {
                    status[j] = 0;
                }
            }else if (sel == 4) {
                for (int j = start-1; j < end; j++) {
                    status[j] = 1;
                }
            }

        }

        for (int result : status) {
            System.out.print(result + " ");
        }
    }

}
