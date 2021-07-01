package chapter3;

import java.util.Arrays;
import java.util.Scanner;
//
public class Greedy_2_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int first = arr[n-1];
		int second = arr[n-2];
		int result = 0;
		
		//가장 큰 수가 더해지는 갯수
		int count = m / (k+1) * k;
		count += m % (k+1);
		
		result += count * first;
		result += (m - count) * second;
		
		System.out.println("result : " + result  );		
		
	}
}
