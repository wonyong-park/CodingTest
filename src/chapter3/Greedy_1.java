package chapter3;

//예제 3-1 거스름돈
public class Greedy_1 {

	public static void main(String[] args) {
		int cost = 1260;
		int[] arr = {500, 100, 50, 10};
		int count = 0;
		
		for(int i : arr){
			count += cost/i;
			cost %= i;
		}
		
		System.out.println("거스름돈의 갯수는 " + count + "개 입니다!");
	}
}
