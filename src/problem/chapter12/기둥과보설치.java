package problem.chapter12;

import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class 기둥과보설치 {

    public int[][] solution(int n, int[][] build_frame) {

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int kind = build_frame[i][2]; //0은 기둥, 1은 보
            int oper = build_frame[i][3]; //0은 삭제, 1은 설치

//            System.out.print("좌표 : ["+x+","+y+"]");
//            System.out.print("\t종류 : " + kind);
//            System.out.println("\t연산 : " + oper);

            //삭제인경우
            if (oper == 0) {
                int index = 0;
                //삭제할 인덱스 찾기
                for (int j = 0; j < answer.size(); j++) {
                    if (answer.get(j).get(0) == x && answer.get(j).get(1) == y && answer.get(j).get(2) == kind) {
                        index = j;
                        break;
                    }
                }

                ArrayList<Integer> erased = answer.get(index);
                answer.remove(index);
                if (!possible(answer)) {
                    answer.add(erased);
                }
            }

            //설치인경우
            if (oper == 1) {
                ArrayList<Integer> insert = new ArrayList<>();
                insert.add(x);
                insert.add(y);
                insert.add(kind);

                answer.add(insert);

                if(!possible(answer)){
                    answer.remove(answer.size() - 1);
                }
            }
        }

        ArrayList<Nodee> list = new ArrayList<>();
        for (ArrayList<Integer> arrayList : answer) {
            list.add(new Nodee(arrayList.get(0), arrayList.get(1), arrayList.get(2)));
        }

        Collections.sort(list);
        int[][] res = new int[list.size()][3];

        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i).x;
            res[i][1] = list.get(i).y;
            res[i][2] = list.get(i).kind;

//            System.out.println(res[i][0] + " " + res[i][1] + " " + res[i][2]);
        }


        return res;
    }

    private boolean possible(ArrayList<ArrayList<Integer>> answer) {

        for (int i = 0; i < answer.size(); i++) {
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int kind = answer.get(i).get(2);

            //기둥인경우
            if (kind == 0) {
                boolean check = false;

                //1. 바닥위에 있는 경우
                if(y == 0) check = true;

                for (int j = 0; j < answer.size(); j++) {
                    if(j == i) continue;

                    //2. 보의 한쪽 끝 부분에 있는 경우
                    if (answer.get(j).get(2) == 1 && x == answer.get(j).get(0) && y == answer.get(j).get(1)) {
                        check = true;
                    }
                    if (answer.get(j).get(2) == 1 && x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1)) {
                        check = true;
                    }

                    //3. 다른 기둥 위에 있는 경우
                    if (answer.get(j).get(2) == 0 && x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1)) {
                        check = true;
                    }
                }
                if(!check) return false;
            }

            //보인경우
            if (kind == 1) {
                boolean check = false;
                boolean left = false;
                boolean right = false;

                for (int j = 0; j < answer.size(); j++) {
                    if(i == j) continue;

                    //1. 한쪽 끝 부분이 다른 기둥 위
                    if (0 == answer.get(j).get(2) && x == answer.get(j).get(0) && y == answer.get(j).get(1) + 1) {
                        check = true;
                    }

                    if (0 == answer.get(j).get(2) && x+1 == answer.get(j).get(0) && y == answer.get(j).get(1) + 1) {
                        check = true;
                    }

                    //2. 양쪽 끝 부분이 다른보와 동시에 연결된 경우
                    if (1 == answer.get(j).get(2) && x == answer.get(j).get(0) + 1 && y == answer.get(j).get(1)) {
                        left = true;
                    }

                    if (1 == answer.get(j).get(2) && x+1 == answer.get(j).get(0) && y == answer.get(j).get(1)) {
                        right = true;
                    }
                }
                if(left&&right) check = true;
                if(!check) return false;
            }
        }

        return true;
    }
}

class Nodee implements Comparable<Nodee>{
    int x;
    int y;
    int kind;

    public Nodee(int x, int y, int kind) {
        this.x = x;
        this.y = y;
        this.kind = kind;
    }

    @Override
    public int compareTo(Nodee o) {
        if (this.x == o.x && this.y == o.y) {
            return this.kind - o.kind;
        }

        if (this.x == o.x) {
            return this.y - o.y;
        }

        return this.x - o.x;
    }
}