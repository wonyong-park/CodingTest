package chapter7;

public class 이진탐색 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;

        binary_search_recursion(arr, target,0, arr.length - 1);
        binary_search_loop(arr, target,0, arr.length - 1);
    }

    //재귀함수를 이용한 이진 탐색
    public static void binary_search_recursion(int[] arr, int target, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            System.out.println((mid+1) + "번째에 값이 있습니다.");
        } else if (arr[mid] > target) {
            binary_search_recursion(arr, target, start, mid - 1);
        } else{
            binary_search_recursion(arr, target, mid + 1, end);
        }

    }

    //반복문을 이용한 이진 탐색
    public static void binary_search_loop(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                System.out.println((mid+1) + "번째에 값이 있습니다.");
                break;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
    }
}
