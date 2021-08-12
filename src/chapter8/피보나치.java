package chapter8;

public class 피보나치 {

    public static int[] d = new int[100];

    public static void main(String[] args) {
//        System.out.println(fibo_inefficient(99));
        System.out.println(fibo_dp_topdown(20));
        System.out.println(fibo_dp_bottomup(20));

    }

    //비효율적인 피보나치
    public static int fibo_inefficient(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        return fibo_inefficient(x - 1) + fibo_inefficient(x - 2);
    }

    //dp를 사용한 피보나치 topdown
    public static int fibo_dp_topdown(int x) {

        //종료 조건
        if (x == 1 || x == 2) {
            return 1;
        }

        //이미 계산한 적이 있는 문제라면 그대로 반환
        if (d[x] != 0) {
            return d[x];
        }

        //아직 계산하지 않은 문제라면 점화식에 따라 피보나치 결과 반환
        d[x] = fibo_dp_topdown(x - 1) + fibo_dp_topdown(x - 2);
        return d[x];
    }

    //dp를 이용한 피보나치 bottomup
    public static int fibo_dp_bottomup(int x) {
        d[1] = 1;
        d[2] = 1;

        for (int i = 3; i <= x; i++) {
            d[x] = d[x - 1] + d[x - 2];
        }

        return d[x];
    }
}
