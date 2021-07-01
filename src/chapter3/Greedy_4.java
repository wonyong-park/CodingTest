package chapter3;

import java.util.Scanner;

//실전 문제 : 1일 될 때 까지 
public class Greedy_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;
		
		while(n != 1){
			if(n%k == 0){
				n /= k;
				count++;
			}else{
				n--;
				count++;
			}
		}
		
		System.out.println("최소 계산 횟수는 : " + count);
	}
}
