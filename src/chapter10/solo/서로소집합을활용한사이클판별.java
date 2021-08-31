package chapter10.solo;

import java.util.Scanner;

public class 서로소집합을활용한사이클판별 {

    public static int v, e;
    public static int[] parent = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        boolean cycle = false;

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }else{
                unionParent(a,b);
            }
        }

        if (cycle) {
            System.out.println("사이클이 발생함");
        }else{
            System.out.println("사이클이 발생하지 않음");
        }
    }

    private static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int a) {
        if(a == parent[a]) return a;
        return parent[a] = findParent(parent[a]);
    }
}
