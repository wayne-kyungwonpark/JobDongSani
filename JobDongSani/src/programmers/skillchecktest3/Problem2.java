package programmers.skillchecktest3;

import java.util.LinkedList;

public class Problem2 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean isPossible = false;
        boolean isBeginInclude = false;
        for (int i = 0; i < words.length; i++) {
            if(target.equals(words[i])){
                isPossible = true;
            }
            if(begin.equals(words[i])){
                isBeginInclude = true;
            }
            if(isPossible){
                break;
            }
        }
        // words에 있는 단어들 중 하나라도 target으로 변화되는 것이 있는지 미리 확인, 아닐 경우 isPossible = false;
        if(isPossible){
            boolean connected = false;
            for (int i = 0; i < words.length; i++) {
                if(isConnected(target, words[i])){
                    connected = true;
                    break;
                }
            }
            if(!connected){
                isPossible = false;
            }
        }
        int N = words.length + 2;
        if(isPossible){
            N--;
            if(isBeginInclude){
                N--;
            }
            String[] allWords = new String[N];
            int index = 0;
            for (int i = 0; i < N; i++) {
                if(i == 0){
                    allWords[i] = begin;
                }else if(i == N - 1){
                    allWords[i] = target;
                }else{
                    if(!begin.equals(words[index]) && !target.equals(words[index])){
                        allWords[i] = words[index];
                    }
                    index++;
                }
            }
            boolean[][] graph = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = i; j < N; j++) {
                    if(i != j && isConnected(allWords[i], allWords[j])){
                        graph[i][j] = true;
                        graph[j][i] = true;
                    }
                }
            }
            String next = allWords[0];
            boolean[] check = new boolean[N];
            LinkedList<Integer> connectList = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if(graph[0][i]){
                    connectList.add(i);
                }
            }
        }
        return answer;
    }

    public boolean isConnected(String target, String word){
        boolean connected = false;
        char[] targetArr = target.toCharArray();
        char[] wordArr = word.toCharArray();
        int sameNum = 0;
        for (int i = 0; i < word.length(); i++) {
            if(targetArr[i] == wordArr[i]){
                sameNum++;
            }
        }
        if(sameNum == word.length() - 1){
            connected = true;
        }
        return connected;
    }
}
