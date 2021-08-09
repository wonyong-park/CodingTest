package chapter6;

public class 삽입정렬 {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        System.out.println("정렬하기 전");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else break;
            }
        }

        System.out.println("정렬한 후");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
