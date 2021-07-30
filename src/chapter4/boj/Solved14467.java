package chapter4.boj;

import java.util.HashMap;
import java.util.Scanner;

public class Solved14467 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int cowNumber = sc.nextInt();
            int cowLoc = sc.nextInt();

            //hash에 안담겨 있는 경우
            if(!hs.containsKey(cowNumber)){
                hs.put(cowNumber, cowLoc);
            }else{
                //hash에 담겨있는 경우
                //값이 같은지 아닌지 비교하면 됨
                int loc = hs.get(cowNumber);

                if (loc != cowLoc) {
                    result++;
                    hs.put(cowNumber, cowLoc);
                }
            }
        }

        System.out.println(result);
    }

}
