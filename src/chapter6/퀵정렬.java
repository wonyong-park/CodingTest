package chapter6;

public class 퀵정렬 {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        System.out.println("정렬하기 전");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();

        quickSort(arr, 0, arr.length - 1);

        System.out.println("정렬한 후");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;
        //피벗은 첫번째 원소로
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            //피벗보다 큰 데이터를 찾을때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) left++;
            while(right > start && arr[right] >= arr[pivot]) right--;

            //엇갈렸다면 작은데이터와 피벗을 교체
            if(left > right){
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        //분할 이후 왼쪽 부분과 오른쪽 부분서에서 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);

    }
}
