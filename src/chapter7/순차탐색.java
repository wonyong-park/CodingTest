package chapter7;

import java.util.Scanner;

public class 순차탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("생성할 원소 갯수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력해라.");
        String str = sc.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        String target = str.split(" ")[1];

        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은띄어쓰기");
        str = sc.nextLine();
        String[] arr = str.split(" ");

        for (String s : arr) {
            System.out.println(s);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {

                System.out.println("같으 단어가 " + (i + 1) + "에 있습니다.");
            }
        }
    }
}
