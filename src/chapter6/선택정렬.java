package chapter6;

public class 선택정렬 {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        System.out.println("정렬하기 전");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            //i는 맨앞의 인덱스
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }

        System.out.println("정렬한 후");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
