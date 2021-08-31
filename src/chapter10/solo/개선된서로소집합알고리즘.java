package chapter10.solo;

import java.util.Scanner;

public class 개선된서로소집합알고리즘 {

    public static int v, e;
    public static int parent[] = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        //입력
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        System.out.print("각 원소가 속한 집합 : " );
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }

        System.out.println();
        System.out.print("각 원소의 부모테이블 : ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
    }

    private static void unionParent(int a, int b) {
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
