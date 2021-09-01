package chapter10.solo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 도시분할계획 {

    public static ArrayList<City> cities = new ArrayList<>();
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int dist = sc.nextInt();

            cities.add(new City(a, b, dist));
        }

        Collections.sort(cities);
        int result = 0;
        int maxCost = 0;
        for (int i = 0; i < cities.size(); i++) {
            int a = cities.get(i).getCityA();
            int b = cities.get(i).getCityB();
            int cost = cities.get(i).getDist();

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                maxCost = Math.max(maxCost, cost);
            }
        }

        System.out.println(result-maxCost);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }


}

class City implements Comparable<City> {
    private int cityA;
    private int cityB;
    private int dist;

    public City(int cityA, int cityB, int dist) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.dist = dist;
    }

    public int getCityA() {
        return cityA;
    }

    public int getCityB() {
        return cityB;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public int compareTo(City o) {
        return this.dist - o.getDist();
    }
}
