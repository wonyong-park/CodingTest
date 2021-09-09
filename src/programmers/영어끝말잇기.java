package programmers;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] result = new int[2];
        List<String> list = new ArrayList<>();

        String preWord = words[0];
        list.add(preWord);
        for (int i = 1; i < words.length; i++) {
            char lastAlpabet = preWord.charAt(preWord.length() - 1);

            if (lastAlpabet == words[i].charAt(0) && !list.contains(words[i])) {
                list.add(words[i]);
                preWord = words[i];
            } else {
                result[0] = i % n + 1;
                result[1] = i / n + 1;
                break;
            }
        }
        return result;
    }
}
