package chapter8.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solved11055 {

    public static int d[] = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            d[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && d[i] < d[j] + arr[i]) {
                    d[i] = d[j] + arr[i];
                }
            }
            max = Math.max(max, d[i]);
        }

        System.out.println(max);
    }
}
