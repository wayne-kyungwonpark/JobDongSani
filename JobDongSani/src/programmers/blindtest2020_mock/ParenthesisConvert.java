package programmers.blindtest2020_mock;

import java.util.Stack;

public class ParenthesisConvert {
    public static void main(String[] args) {
//        String p = "(()())()";
//        String p = ")(";
        String p = "()))((()";
//        System.out.println(p.substring(p.length()));
//        System.out.println(correct(p));
        System.out.println(solution(p));
    }

    public static String solution(String p) {
        String answer = convert(p);
        return answer;
    }

    private static String convert(String s){
        if(s.equals("")){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        // u, v 분리
        int left = 0;
        int right = 0;
        char[] chArr = s.toCharArray();
        String u = null;
        String v = null;
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] == '('){
                left++;
            }else{
                right++;
            }
            if(left != 0 && left == right){
                u = s.substring(0, i + 1);
                v = s.substring(i + 1);
                break;
            }
        }
        boolean uCorrect = correct(u);
        if(v.equals("") && uCorrect){
            return s;
        }
        if(uCorrect){
            sb.append(u).append(convert(v));
        }else{
            sb.append("(");
            sb.append(convert(v));
            sb.append(")");
            char[] uChArr = u.toCharArray();
            for (int i = 1; i < uChArr.length - 1; i++) {
                if(uChArr[i] == '('){
                    sb.append(")");
                }else{
                    sb.append("(");
                }
            }
        }

        return sb.toString();
    }

    private static boolean correct(String s){
        if(s == null){
            return true;
        }
        char[] chArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] == '('){
                stack.push(chArr[i]);
            }else{
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(chArr[i]);
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
