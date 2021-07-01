package chapter4;

import java.util.Scanner;

//예제 4-2 시각
public class Implement_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 60; j++) {
				for (int k = 0; k < 60; k++) {
					String str = ""+i+j+k;
					
					if(str.contains("3")){
						count++;
						System.out.println("str => " + str);
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
