package algorithm.leetcode.hard;

import java.util.Arrays;

public class _1402_ReducingDishes {
    public static void main(String[] args) {
        int[] satisfaction = {-2,5,-1,0,3,-3};
        System.out.println(maxSatisfaction(satisfaction));
    }

    public static int maxSatisfaction(int[] satisfaction) {
        int answer = 0;
        Arrays.sort(satisfaction);
        if(satisfaction[0] >= 0){
            for (int i = 0; i < satisfaction.length; i++) {
                answer += satisfaction[i] * (i + 1);
            }
            return answer;
        }else if(satisfaction[satisfaction.length - 1] < 0){
            return answer;
        }

        int negIndex = 0;
        int posSum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if(satisfaction[i] < 0){
                negIndex = i;
                break;
            }else{
                posSum += satisfaction[i];
            }
        }

        int[] negPartialSum = new int[negIndex + 1];
        negPartialSum[negIndex] = satisfaction[negIndex];
        for (int i = negIndex - 1; i >= 0; i--) {
            negPartialSum[i] = negPartialSum[i + 1] + satisfaction[i];
        }

        int value = 0; // 이전값
        int time = 1;
        for (int i = negIndex + 1; i < satisfaction.length; i++) {
            value += time * satisfaction[i];
            time++;
        }

        answer = value; // 정답

        for (int i = negIndex; i >= 0; i--) {
            value += (posSum + negPartialSum[i]);
            answer = Math.max(answer, value);
        }

        return answer;
    }
}
