package programmers.blindtest2020_mock;

import java.util.HashMap;
import java.util.Map;

public class LyricSearch {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
        int[] answer = solution(words, queries);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            if(map.containsKey(queries[i])){
                answer[i] = map.get(queries[i]);
                continue;
            }
            int nums = 0;
            char[] queryChArr = queries[i].toCharArray();
            for (int j = 0; j < words.length; j++) {
                if(queries[i].length() != words[j].length()){
                    continue;
                }
                boolean isPossible = true;
                char[] chArr = words[j].toCharArray();
                if(queryChArr[0] == '?'){
                    for (int k = chArr.length - 1; k >= 0; k--) {
                        if(queryChArr[k] != '?'){
                            if(chArr[k] != queryChArr[k]){
                                isPossible = false;
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }else{
                    for (int k = 0; k < chArr.length; k++) {
                        if(queryChArr[k] != '?'){
                            if(chArr[k] != queryChArr[k]){
                                isPossible = false;
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }
                if(isPossible){
                    nums++;
                }
            }
            map.put(queries[i], nums);
            answer[i] = nums;
        }
        return answer;
    }
}
