package problem.chpater11;

import java.util.*;

public class 만들수없는금액 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        int target = 1;
        for (int i = 0; i < n; i++) {
            //만들 수 없는 금액을 찾았을 때 반복 종료
            if(target < arrayList.get(i)) break;
            target += arrayList.get(i);
            System.out.println("target = " + target);

        }
    }

    /*
    실패코드 ㅠㅅㅠ
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            set.add(sum);
            for (int j = i+1; j < arr.length; j++) {
                sum += arr[j];
                set.add(sum);
            }
        }

        for (int i = 1; i < 1001; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }

    }
     */
}
