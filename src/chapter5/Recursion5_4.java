package chapter5;

public class Recursion5_4 {

	public static void main(String[] args) {
		recursive_function(0);
	}
	
	public static void recursive_function(int i){
		
		if(i == 100) return;
		System.out.println(i+ "번째 재귀 함수에서" + (i+1) + "번째 재귀함수를 호출합니다.");
		recursive_function(i+1);
		System.out.println(i +"번째 재귀함수를 종료합니다.");
	}
}
