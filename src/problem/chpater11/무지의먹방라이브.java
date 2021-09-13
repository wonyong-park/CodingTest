package problem.chpater11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 무지의먹방라이브 {

    public static void main(String[] args) {
        무지의먹방라이브 m = new 무지의먹방라이브();
        int[] food_times = {3, 1, 2};
        int k = 5;
        System.out.println(m.solution(food_times, k));
    }

    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> pq = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < food_times.length ; i++) {
            pq.add(new Food(i + 1, food_times[i]));
            sum += food_times[i];
        }

        //-1인조건
        if(sum <= k) return -1;

        long summary = 0; //먹기 위해 사용한 시간
        long previous = 0; //직전에 다 먹은 시간
        long length = food_times.length;

        //summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k비교
        while (summary + (pq.peek().time - previous) * length <= k) {
            int now = pq.poll().time;
            summary += (now - previous) * length;
            length--;
            previous = now;
        }

        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.num - o2.num;
            }
        });

        return result.get((int) ((k - summary) % length)).num;
    }
}

class Food implements Comparable<Food> {
    int num;
    int time;

    public Food(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Food o) {
        return this.time - o.time;
    }
}

