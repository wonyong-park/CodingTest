package chapter4.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solved1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = {"000", "001", "010", "011", "100", "101", "110", "111"};
        StringBuffer sb = new StringBuffer();
        String input = br.readLine();

        sb.append(Integer.parseInt(arr[input.charAt(0) - '0']));

        for (int i = 1; i < input.length(); i++) {
            sb.append(arr[input.charAt(i) - '0']);
        }

        System.out.println(sb);
    }
}
