package programmers;

public class 모음사전 {
    public static char[] dic = {'A', 'E', 'I', 'O', 'U'};
    public static int count = 0;
    public static int answer = 0;

    public int solution(String word) {
        for (int i = 0; i < dic.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(dic[i]);
            dfs(sb, word);
        }
        return answer;
    }

    private void dfs(StringBuilder sb, String word) {
        if (sb.length() == 6) {
            return;
        }

        count++;
        if (word.equals(sb.toString())) {
            answer = count;
            return;
        }

        for (int i = 0; i < dic.length; i++) {
            sb.append(dic[i]);
            dfs(sb,word);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
