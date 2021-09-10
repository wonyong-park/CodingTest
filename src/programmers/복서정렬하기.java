package programmers;
import java.util.ArrayList;
import java.util.Collections;

public class 복서정렬하기 {
    public int[] solution(int[] weights, String[] head2head) {
        int n = head2head.length;
        int[] answer = new int[n];

        ArrayList<Player> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int weight = weights[i]; //자신의 몸무게
            int number = i + 1; //플레이어 번호
            String vs = head2head[i]; //경기 결과
            int totalMatches = 0;
            int win = 0;
            int winBigger = 0;

            for (int j = 0; j < vs.length(); j++) {
                char result = vs.charAt(j);
                if (result == 'N') {
                    continue;
                } else if (result == 'W') {
                    //이긴 경우
                    totalMatches++;
                    win++;
                    if (weight < weights[j]) {
                        winBigger++;
                    }
                } else {
                    //진 경우
                    totalMatches++;
                }
            }
            if (totalMatches != 0) {
                list.add(new Player(number, (double)win / totalMatches, weight, winBigger));
            }else{
                list.add(new Player(number, 0, weight, winBigger));
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).number;
        }

        return answer;
    }
}

class Player implements Comparable<Player>{
    int number;
    double winRate;
    int weight;
    int winBigger;

    @Override
    public int compareTo(Player o) {

        if (this.winRate == o.winRate && this.winBigger == o.winBigger && this.weight == o.weight) {
            return this.number - o.number;
        }

        if (this.winRate == o.winRate && this.winBigger == o.winBigger) {
            return o.weight - this.weight;
        }

        if (this.winRate == o.winRate) {
            return o.winBigger - this.winBigger;
        }

        return (int)(o.winRate - this.winRate);

    }

    public Player(int number, double winRate, int weight, int winBigger) {
        this.number = number;
        this.winRate = winRate*100000000;
        this.weight = weight;
        this.winBigger = winBigger;
    }
}
