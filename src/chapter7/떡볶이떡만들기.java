package chapter7;

import java.util.Scanner;

public class 떡볶이떡만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //떡의 갯수
        int N = sc.nextInt();
        //원하는 떡의 길이
        int M = sc.nextInt();
        sc.nextLine();

        int end = 0;
        int[] dducks = new int[N];
        for (int i = 0; i < N; i++) {
            dducks[i] = sc.nextInt();
            end = Math.max(dducks[i], end);
        }

        int start = 0;
        int result = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int total = 0;

            for (int i = 0; i < dducks.length; i++) {
                int k = dducks[i] - mid;
                if (k > 0) {
                    total += k;
                }
            }

            //떡의 양이 부족한 상태
            if (total < M) {
                end = mid - 1;
            }
            //떡이 양이 충분한경우
            //값을 기억해놓고 최대한 덜잘랐을때를 구해야함
            else{
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);


    }
}
