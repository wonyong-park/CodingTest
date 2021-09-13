package problem.chpater11;

import java.util.Scanner;

public class 볼링공고르기 {

    public static int[] arr = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[x] += 1;
        }

        int result = 0;

        for (int i = 1; i <= m; i++) {
            n -= arr[i];
            result += arr[i] * n;
        }
    }

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int select = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (select != arr[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
     */
}
