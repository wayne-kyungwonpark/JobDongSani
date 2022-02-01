package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _290_WordPattern {
    public static void main(String[] args) {

    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternToWord = new HashMap<>();
        Set<String> check = new HashSet<>();
        char[] patterns = pattern.toCharArray();
        String[] strs = s.split(" ");

        boolean answer = true;

        if(patterns.length != strs.length){
            return false;
        }
        for (int i = 0; i < patterns.length; i++) {
            if(strs.length < i){
                answer = false;
                break;
            }

            if(patternToWord.containsKey(patterns[i])){
                if(!patternToWord.get(patterns[i]).equals(strs[i])){
                    answer = false;
                    break;
                }
            }else{
                if(check.contains(strs[i])){
                    answer = false;
                    break;
                }
                patternToWord.put(patterns[i], strs[i]);
                check.add(strs[i]);
            }
        }
        return answer;
    }
}
