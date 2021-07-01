package chapter3;

import java.util.Arrays;
import java.util.Scanner;

//실전 문제 : 큰 수의 법칙 
public class Greedy_2 {
	
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
		
		//가장 큰수
		int first = arr[n-1];
		int second = arr[n-2];
		int result = 0;
		while(true){
			for (int i = 0; i < k; i++) {
				if(m == 0) break;
				result += first;
				m--;
			}
			
			if(m == 0) break;
			result += second;
			m--;
			
		}
		
		System.out.println("result : " + result  );
		
	}
}
