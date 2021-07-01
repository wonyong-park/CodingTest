package chapter3;

import java.util.Arrays;
import java.util.Scanner;

//실전 문제 : 숫자 카드 게임 
public class Greedy_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int[] arr = new int[m];
			for (int j = 0; j < m; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			max = Math.max(arr[0], max);
		}
		
		System.out.println("최대값은 : " + max);
	}

}
