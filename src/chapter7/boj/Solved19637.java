package chapter7.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solved19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Item> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Item(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            result.append(binarySearch(Integer.parseInt(br.readLine()), list)).append("\n");
        }

        System.out.println(result);
    }

    private static String binarySearch(int stat, List<Item> list) {
        int start = 0;
        int end = list.size() - 1;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (stat > list.get(mid).getValue()) {
                start = mid + 1;
            }else{
                end = mid - 1;
                result = mid;
            }

        }

        return list.get(result).getName();
    }

}

class Item{
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}