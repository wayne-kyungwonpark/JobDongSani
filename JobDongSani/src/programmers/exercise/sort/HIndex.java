package programmers.exercise.sort;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {5, 5, 5, 5};
//        int[] citations = {5, 5, 5, 5, 5};
//        int[] citations = {5};
        int[] citations = {0};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = citations.length;

        Arrays.sort(citations);
        int index = 0;
        while(index < citations.length && answer >= 0){
            if(citations[index] >= answer){
                break;
            }else{
                index++;
                answer--;
            }
        }

        return answer;
    }
}
