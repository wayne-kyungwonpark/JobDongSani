package programmers.blindtest2018;

import java.util.Arrays;

public class Problem4Eff {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int minCapFood = findMinElem(food_times);
        int foodNums = food_times.length;

        long totalSum = 0;
        for (int i = 0; i < food_times.length; i++) {
            totalSum += ((long) food_times[i]);
        }
        if(k >= totalSum){
            return -1;
        }

        // 돌면서 foodNums가 바뀔 수 있는 과정을 없앤다.
        int[] sorted_food_times = Arrays.copyOf(food_times, food_times.length);
        Arrays.sort(sorted_food_times);
        int minIndex = 0;
        int minCapSum = 0;
        while((long) minCapFood * (long) foodNums <= k){
            int nums = 0;
            minCapSum = sorted_food_times[minIndex];
            for (int i = minIndex; i < sorted_food_times.length; i++) {
                if(sorted_food_times[i] == minCapSum){
                    nums++;
                }else{
                    minIndex = i;
                    break;
                }
            }
            k -= ((long) minCapFood * (long) foodNums);
            foodNums -= nums;
            minCapFood = sorted_food_times[minIndex] - minCapSum;
            if(minIndex == sorted_food_times.length - 1 || foodNums == 0){
                break;
            }
        }

        for (int i = 0; i < food_times.length; i++) {
            if(food_times[i] >= minCapSum){
                food_times[i] -= minCapSum;
            }else{
                food_times[i] = 0;
            }
        }

        // foodNums는 고정 (남은 시간 동안 돌아도 food_time의 어떤 element라도 0이 안 됨)
        long rest = (k + 1) % (long) foodNums;
        if(rest == 0){
            rest = foodNums;
        }
        int index = 0;
        for (int i = 0; i < food_times.length; i++) {
            if(food_times[i] != 0){
                index++;
            }
            if(index == rest){
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    private int findMinElem(int[] arr){
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if(min == 0 || (arr[i] != 0 && arr[i] < min)){
                min = arr[i];
            }
        }
        return min;
    }
}
