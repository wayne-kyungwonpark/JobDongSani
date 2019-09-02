package programmers.skillchecktest1;

public class Problem1 {
    public int solution(String s) {
        int answer = 0;
        String first = s.substring(0, 1);
        if("+".equals(first)){
            answer = Integer.parseInt(s.substring(1));
        }else if("-".equals(first)){
            answer = -Integer.parseInt(s.substring(1));
        }else{
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}
