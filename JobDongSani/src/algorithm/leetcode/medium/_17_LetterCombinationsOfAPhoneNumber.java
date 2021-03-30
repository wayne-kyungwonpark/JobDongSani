package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _17_LetterCombinationsOfAPhoneNumber {
    private static char[][] digitToAlphabet = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},
            {'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public static void main(String[] args) {
        String digits = "23";
//        System.out.println(String.valueOf(digitToAlphabet[2]));
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if("".equals(digits)){
            return answer;
        }

        char[] chArr = digits.toCharArray();
        int[] digitArr = new int[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            digitArr[i] = Integer.parseInt(String.valueOf(chArr[i]));
        }

        Stack<Character> stack = new Stack<>();

        find(digitArr, answer, stack, 0);

        return answer;
    }

    private static void find(int[] digitArr, List<String> answer, Stack<Character> stack, int index) {
        if(index == digitArr.length){
            char[] candidate = new char[stack.size()];
            int tmp = candidate.length - 1;
            while(!stack.isEmpty()){
                candidate[tmp--] = stack.pop();
            }
            answer.add(String.valueOf(candidate));
            for (int i = 0; i < candidate.length; i++) {
                stack.push(candidate[i]);
            }
            return;
        }

        for (int i = 0; i < digitToAlphabet[digitArr[index]].length; i++) {
            stack.push(digitToAlphabet[digitArr[index]][i]);
            find(digitArr, answer, stack, index + 1);
            stack.pop();
        }
    }
}
