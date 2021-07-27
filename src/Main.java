import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = {"000", "001", "010", "011", "100", "101", "111", "111"};
        String result = "";

//        String input = sc.nextLine();
        String input = br.readLine();

        for (int i = input.length()-1; i > 0; i--) {
            result = arr[Integer.parseInt(input.charAt(i) + "")] + result;
        }

        int first = Integer.parseInt(arr[Integer.parseInt(input.charAt(0)+"")]);

        result = first + result;

        System.out.println(result);
    }
}
