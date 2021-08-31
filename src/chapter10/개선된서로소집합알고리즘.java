package chapter10;

import java.util.Scanner;

public class 개선된서로소집합알고리즘 {

    //노드의 개수 v와 간선의 개수 e
    //노드의 개수는 최대 100000개라 가정
    public static int v, e;
    public static int[] parent = new int[100001];

    //특정 원소가 속한 집합 찾기
    public static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 1; i<= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        //각 원소가 속한 집합
        System.out.print("각 원소가 속한 집합 : ");
        for (int i = 1; i <= v ; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        //부모 테이블 내용 출력하기
        System.out.print("부모 테이블 : ");
        for (int i = 1; i <= v ; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
