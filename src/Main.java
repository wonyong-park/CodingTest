import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        int[] sum = new int[N];
        int maxTotal = 0;

        arr[0] = sc.nextInt();
        sum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum[i] = arr[i] + sum[i - 1];
        }

        //벌 벌 꿀통 순
        for (int i = 1; i < arr.length - 1; i++) {
            maxTotal = Math.max(maxTotal, sum[arr.length - 1] - arr[0] - sum[i] + sum[arr.length - 1] - sum[i]);
        }

        //꿀통 벌 벌 순
        for (int i = 1; i < arr.length - 1; i++) {
            maxTotal = Math.max(maxTotal, sum[arr.length - 1] - arr[arr.length-1] - arr[i] + sum[i - 1]);
        }

        //벌 꿀통 벌 순
        for (int i = 1; i < arr.length-1; i++) {
            maxTotal = Math.max(maxTotal, sum[i] - arr[0] + sum[arr.length - 1] - arr[arr.length-1] - sum[i-1]);
        }

        System.out.print(maxTotal);
    }
}
