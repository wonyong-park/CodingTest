package chapter5;

public class Recursion5_3 {

	public static void main(String[] args) {
		recursive_function();
	}
	
	public static void recursive_function(){
		System.out.println("재귀 함수 호출");
		
		recursive_function();
	}
}
