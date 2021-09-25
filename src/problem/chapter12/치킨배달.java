package problem.chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class 치킨배달 {

    public static int[][] map = new int[51][51];
    public static int n, m;
    public static ArrayList<Pos> house = new ArrayList<>();
    public static ArrayList<Pos> chicken = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                map[r][c] = sc.nextInt();

                //집인경우
                if (map[r][c] == 1) {
                    house.add(new Pos(r, c));
                }

                //치킨집인경우
                if (map[r][c] == 2) {
                    chicken.add(new Pos(r, c));
                }
            }
        }

        //치킨집갯수 = chicken.size()
        //치킨집갯수에서 m개를 뽑아서 최소값을 확인하면 될 듯
        Combination comb = new Combination(chicken.size(), m);
        comb.combination(chicken, 0, 0, 0);

        ArrayList<ArrayList<Pos>> chickenList = comb.getResult();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }

        System.out.println(result);
    }

    private static int getSum(ArrayList<Pos> candidates) {
        int result = 0;

        for (int i = 0; i < house.size(); i++) {
            int hx = house.get(i).x;
            int hy = house.get(i).y;

            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).x;
                int cy = candidates.get(j).y;
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }

            result += temp;
        }

        return result;
    }

}

class Combination{
    private int n;
    private int r;
    private int[] now;
    private ArrayList<ArrayList<Pos>> result;

    //nCr
    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public ArrayList<ArrayList<Pos>> getResult() {
        return result;
    }

    public void combination(ArrayList<Pos> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Pos> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if(target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }

}

class Pos{
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
