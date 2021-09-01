package chapter10.solo;

import java.util.Scanner;

public class 팀결성 {

    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            //0인경우 팀 합치기 => union
            //1인경우 같은 팀 여부 확인 => find
            int order = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (order == 0) {
                unionParent(a, b);
            }else{
                if (findParent(a) == findParent(b)) {
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }

    public static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }
}
