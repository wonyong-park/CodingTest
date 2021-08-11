package chapter7;

import java.util.HashSet;
import java.util.Scanner;

public class 부품찾기set {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(sc.nextInt());
        }

        sc.nextLine();

        int m = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            if (hs.contains(k)) {
                sb.append("yes ");
            }else{
                sb.append("no ");
            }
        }

        System.out.println("sb.toString() = " + sb.toString());

    }
}
