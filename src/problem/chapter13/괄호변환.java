package problem.chapter13;

public class 괄호변환 {

    public static void main(String[] args) {
        괄호변환 s = new 괄호변환();
        s.solution("()))((()");
        String p = "()))((()";
    }

    /**
     * '('의 갯수와 ')'의 갯수가 같으면 균형잡힌 괄호 문자열
     * 짝도 맞은경우 올바른 괄호 문자열
     *
     */
    public String solution(String p) {
        String answer = "";
        if(p.equals("")) return "";

        int index = balancedString(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        //문자열 u가 올바른 괄호 문자열인경우
        if (checkString(u)) {
            answer = u + solution(v);
        }else{
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1);
            String temp = "";
            for (int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') temp += ')';
                else temp += '(';
            }
            answer += temp;
        }

        return answer;
    }

    public int balancedString(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)=='(') count++;
            else count--;

            if (count == 0) {
                return i;
            }
        }

        return -1;
    }

    public boolean checkString(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') count++;
            else{
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return true;
    }

}
