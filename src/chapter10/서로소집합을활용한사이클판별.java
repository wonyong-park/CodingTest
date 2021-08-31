package chapter10;

import java.util.Scanner;

public class 서로소집합을활용한사이클판별{

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

        boolean cycle = false;

        for (int i = 0; i < e; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }else{
                unionParent(a, b);
            }
            for (int j = 1; j <= v; j++) {
                System.out.print(parent[j] + " ");
            }
            System.out.println();

        }

        if (cycle) {
            System.out.println("사이클이 발생했다.");
        }else{
            System.out.println("사이클이 발생하지않았다.");
        }
    }
}
