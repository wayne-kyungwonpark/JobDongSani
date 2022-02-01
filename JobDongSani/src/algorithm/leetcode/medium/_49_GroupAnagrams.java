package algorithm.leetcode.medium;

import java.util.*;

public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String strTmp = new String(tmp);
            if(map.containsKey(strTmp)){
                map.get(strTmp).add(str);
            }else{
                List<String> newElem = new ArrayList<>();
                newElem.add(str);
                map.put(strTmp, newElem);
            }
        }

        for(List value : map.values()){
            answer.add(value);
        }

        return answer;
    }
}
