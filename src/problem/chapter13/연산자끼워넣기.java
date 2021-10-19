package problem.chapter13;

import java.util.Scanner;

public class 연산자끼워넣기 {

    public static int n;
    public static int[] arr;
    public static int add,minus,mul,div;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        add = sc.nextInt();
        minus = sc.nextInt();
        mul = sc.nextInt();
        div = sc.nextInt();

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int i, int now) {
        if (i == n) {
            min = Math.min(min, now);
            max = Math.max(max, now);
        }else{

            if (add > 0) {
                add--;
                dfs(i + 1, now + arr[i]);
                add++;
            }

            if (minus > 0) {
                minus--;
                dfs(i + 1, now - arr[i]);
                minus++;
            }

            if (mul > 0) {
                mul--;
                dfs(i + 1, now * arr[i]);
                mul++;
            }

            if (div > 0) {
                div--;
                dfs(i + 1, now / arr[i]);
                div++;
            }
        }
    }
}
