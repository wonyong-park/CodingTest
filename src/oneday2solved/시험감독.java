package oneday2solved;

import java.util.Scanner;

public class 시험감독 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] places = new int[N];
        for (int i = 0; i < places.length; i++) {
            places[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        int C = sc.nextInt();

        long total = 0;

        for (int i = 0; i < places.length; i++) {
            int temp = places[i];

            //총 감독관 1
            total++;
            temp -= B;

            if(temp > 0){
                if(temp%C != 0){
                    total += temp / C + 1;
                }else{
                    total += temp / C;
                }
            }
        }

        System.out.println(total);
    }
}
