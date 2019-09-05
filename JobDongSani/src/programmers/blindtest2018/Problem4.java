package programmers.blindtest2018;

public class Problem4 {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int minCapFood = findMinElem(food_times);
        int foodNums = food_times.length;

        // 돌면서 foodNums가 바뀔 수 있는 과정
        while(minCapFood * foodNums <= k){
            for (int i = 0; i < food_times.length; i++) {
                if(food_times[i] != 0){
                    food_times[i] -= minCapFood;
                }
            }
            k -= ((long)minCapFood * (long)foodNums);
            minCapFood = findMinElem(food_times);
            if(minCapFood == 0){
                break;
            }else{
                foodNums = 0;
                for (int i = 0; i < food_times.length; i++) {
                    if(food_times[i] != 0){
                        foodNums++;
                    }
                }
            }
        }

        if(minCapFood == 0){
            return -1;
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
