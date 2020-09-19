package programmers.blindtest2020_mock;

public class StringCompression {
    public static void main(String[] args) {
//        String s = "aabbaccc";
//        String s = "ababcdcdababcdcd";
//        String s = "abcabcdede";
//        String s = "abcabcabcabcdededededede";
        String s = "xababcdcdababcdcd";
//        System.out.println(s.substring(0, s.length()));
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = s.length();
        int maxSize = s.length() / 2;
        for (int size = 1; size <= maxSize; size++) {
            int index = 0;
            int length = 0;
            String prev = null;
            int freq = 1;
            while(index < s.length()){
                int nextIndex = index + size;
                if(nextIndex > s.length()){
                    nextIndex = s.length();
                }
                String cur = s.substring(index, nextIndex);
                if(prev != null){
                    if(prev.equals(cur)){
                        freq++;
                    }else{
                        length += size;
                        if(freq != 1){
                            length += String.valueOf(freq).length();
                        }
                        freq = 1;
                        prev = cur;
                    }
                }else{
                    prev = cur;
                    freq = 1;
                }
                index = nextIndex;
            }
            int rest = s.length() % size;
            if(freq != 0){
                if(rest == 0){
                    length += size;
                }else{
                    length += rest;
                }
                if(freq != 1){
                    length += String.valueOf(freq).length();
                }
            }
            answer = Math.min(answer, length);
        }
        return answer;
    }
}
