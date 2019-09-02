package programmers.skillchecktest1_1;

public class Problem1Easy {
    public int[] solution(int []arr) {
        int[] answer = {};
        int[] tmp = new int[arr.length];
        int tmpIndex = 0;
        int continuous = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == 0){
                continuous = arr[i];
                tmp[tmpIndex++] = arr[i];
            }else{
                if(continuous != arr[i]){
                    tmp[tmpIndex++] = arr[i];
                    continuous = arr[i];
                }
            }
        }
        answer = new int[tmpIndex];
        for (int i = 0; i < tmpIndex; i++) {
            answer[i] = tmp[i];
        }
        return answer;
    }
}
