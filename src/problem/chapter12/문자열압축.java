package problem.chapter12;

public class 문자열압축 {

    public static void main(String[] args) {
        문자열압축 s = new 문자열압축();
        String str = "aabbaccc";
        System.out.println(s.solution("aabbaccc"));
//        String s1 = str.substring(0,1);
//        System.out.println(s1);

    }

    public int solution(String s) {
        int answer = s.length();

        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String preWord = s.substring(0, step);
            int count = 1;

            for (int i = step; i < s.length(); i += step) {
                String nextWord = "";
                int endIndex = i + step;
                if (endIndex > s.length()) {
                    endIndex = s.length();
                }
                nextWord = s.substring(i, endIndex);

                if (preWord.equals(nextWord)) {
                    count++;
                }
                else{
                    compressed += (count >= 2) ? count + preWord : preWord;
                    count = 1;
                    preWord = nextWord;
                }
            }

            compressed += (count >= 2) ? count + preWord : preWord;
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
