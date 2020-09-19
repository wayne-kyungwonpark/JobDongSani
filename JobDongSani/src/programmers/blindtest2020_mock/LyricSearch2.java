package programmers.blindtest2020_mock;

import java.util.HashMap;
import java.util.Map;

public class LyricSearch2 {
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

        // words로 trie 만들기
        // 만들 때 각 TrieNode 별로 남은 자릿수 별 word 갯수를 가지고 있어야 함
        // 1. 정방향 trie
        TrieNode trie1 = new TrieNode();
        // 2. 역방향 trie
        TrieNode trie2 = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            char[] chArr1 = words[i].toCharArray();
            char[] chArr2 = new char[chArr1.length];
            for (int j = 0; j < chArr1.length; j++) {
                chArr2[j] = chArr1[chArr1.length - 1 - j];
            }
            trie1.insert(chArr1, 0);
            trie2.insert(chArr2, 0);
        }

        // query 별로 해당하는 word 갯수 찾기
        Map<String, Integer> queryMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            if(queryMap.containsKey(queries[i])){
                answer[i] = queryMap.get(queries[i]);
                continue;
            }

            char[] chArr = queries[i].toCharArray();
            if(chArr[0] == '?'){
                char[] reverseChArr = new char[chArr.length];
                for (int j = 0; j < chArr.length; j++) {
                    reverseChArr[j] = chArr[chArr.length - 1 - j];
                }
                answer[i] = trie2.find(reverseChArr, 0);
            }else{
                answer[i] = trie1.find(chArr, 0);
            }
            queryMap.put(queries[i], answer[i]);
        }

        return answer;
    }

    private static class TrieNode{
        boolean terminate;
        Map<Character, TrieNode> children = new HashMap<>();
        Map<Integer, Integer> wordLength = new HashMap<>();

        public void insert(char[] chArr, int index){
            if(index >= chArr.length){
                return;
            }
            wordLength.put(chArr.length - index, wordLength.getOrDefault(chArr.length - index, 0) + 1);
            if(index == chArr.length - 1){
                terminate = true;
                return;
            }
            if(!children.containsKey(chArr[index])){
                children.put(chArr[index], new TrieNode());
            }
            children.get(chArr[index]).insert(chArr, index + 1);
        }

        public int find(char[] chArr, int index){
            if(chArr[index] == '?'){
                return wordLength.getOrDefault(chArr.length - index, 0);
            }

            if(children.containsKey(chArr[index])){
                return children.get(chArr[index]).find(chArr, index + 1);
            }

            return 0;
        }
    }
}
