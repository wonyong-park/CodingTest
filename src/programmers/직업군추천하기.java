package programmers;

import java.util.PriorityQueue;

public class 직업군추천하기 {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        PriorityQueue<Job> pq = new PriorityQueue<>();

        for (int i = 0; i < table.length; i++) {
            String[] temp = table[i].split(" ");
            String title = temp[0];
            int score = 0;
            int languageJumsu = 1;
            for (int j = 5; j > 0 ; j--) {
                for (int k = 0; k < languages.length; k++) {
                    if (temp[j].equals(languages[k])) {
                        score += preference[k] * languageJumsu;
                    }
                }

                languageJumsu++;
            }

            pq.offer(new Job(title, score));
        }

        return pq.poll().name;
    }
}

class Job implements Comparable<Job>{
    String name;
    int score;

    public Job(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Job o) {
        if (this.score == o.score) {
            return this.name.compareTo(o.name);
        }
        return o.score - this.score;
    }
}
