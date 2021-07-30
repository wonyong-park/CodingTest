package chapter4.boj;

import java.util.Scanner;

public class Solved20546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int aMoney = money;
        int bMoney = money;

        int price[] = new int[14];
        for (int i = 0; i < price.length; i++) {
            price[i] = sc.nextInt();
        }

        //준현이
        int aStockCount = 0;
        for (int i = 0; i < price.length ; i++) {
            if(aMoney >= price[i]){
                aStockCount += aMoney / price[i];
                aMoney = aMoney % price[i];
            }
        }

        int bStockCount = 0;
        for (int i = 3; i < price.length ; i++) {
            //가격이 떨어지는경우
            if(price[i-3] > price[i-2] && price[i-2] > price[i-1] && price[i-1] > price[i]){
                //전량 매수
                if(bMoney >= price[i]){
                    bStockCount += bMoney / price[i];
                    bMoney = bMoney % price[i];
                }
            }
            //가격이 오르는경우
            else if(price[i-3] < price[i-2] && price[i-2] < price[i-1] && price[i-1] < price[i]){
                //오른경우 전량매도
                if(bStockCount > 0){
                    bMoney += bStockCount * price[i];
                    bStockCount = 0;
                }
            }
        }

        int aTotal = aMoney + price[13] * aStockCount;
        int bTotal = bMoney + price[13] * bStockCount;

        if(aTotal > bTotal){
            System.out.println("BNP");
        }else if(aTotal < bTotal){
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }
    }
}
