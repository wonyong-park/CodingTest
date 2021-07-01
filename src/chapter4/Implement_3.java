package chapter4;

import java.util.Scanner;

//실전 문제 : 왕실의 나이트
public class Implement_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pos = sc.nextLine();
		int row = (int)pos.charAt(0) - 'a' + 1;
		int colum = Integer.parseInt(pos.charAt(1)+"");
		int count = 0;
		
		int[] stepx = {2,2,-1,-1,1,1,-1,-1};
		int[] stepy = {1,-1,1,-1,2,-2,2,-2};
		
		for (int i = 0; i < 8; i++) {
			int nx = row + stepx[i];
			int ny = colum + stepy[i];
			if(nx < 1 || ny < 1 || nx > 8 || ny > 8) continue;
			count++;
		}
		
		System.out.println("count : " + count);
		
	}
}
