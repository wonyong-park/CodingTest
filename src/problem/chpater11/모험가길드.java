package problem.chpater11;

import java.util.Arrays;
import java.util.Scanner;

public class 모험가길드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //정렬
        Arrays.sort(nums);

        int result = 0;
        int count = 0;
        for (int num : nums) {
            count++;
            if (num >= count) {
                result++;
                count = 0;
            }
        }

        System.out.println(result);
    }
}
