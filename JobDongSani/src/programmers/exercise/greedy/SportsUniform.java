package programmers.exercise.greedy;

import java.util.Arrays;

public class SportsUniform {
    public static void main(String[] args) {
//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reserve = {1, 3, 5};
//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reserve = {3};
//        int n = 3;
//        int[] lost = {3};
//        int[] reserve = {1};
        int n = 5;
        int[] lost = {1, 2};
        int[] reserve = {2, 3};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] checkForReserve = new boolean[reserve.length]; // 여분을 가져왔지만, 자신의 체육복을 잃어버려 빌려줄 수 없는 학생에 true 체크
        for (int i = 0; i < lost.length; i++) {
            int index = Arrays.binarySearch(reserve, lost[i]);
            if(index >= 0){
                checkForReserve[index] = true;
            }
        }
        boolean[] checkForLost = new boolean[lost.length]; // 체육복을 잃어버렸으나, 자신이 여분을 가져와 자기 자신에게 빌릴 수 있는 학생에 true 체크
        for (int i = 0; i < reserve.length; i++) {
            int index = Arrays.binarySearch(lost, reserve[i]);
            if(index >= 0){
                checkForLost[index] = true;
            }
        }

        int j = 0;
        for (int i = 0; i < lost.length; i++) {
            while(j < reserve.length){
                if(!checkForLost[i] && !checkForReserve[j] && reserve[j] == lost[i] - 1){ // ex. lost: 2, reserve: 1
                    answer++;
                    j++;
                    break;
                }else if(checkForLost[i]){ // ex. lost: 2, reserve: 2
                    answer++;
                    j++;
                    break;
                }else if(!checkForLost[i] && !checkForReserve[j] && reserve[j] == lost[i] + 1){ // ex. lost: 2, reserve: 3
                    answer++;
                    j++;
                    break;
                }else{
                    if(reserve[j] > lost[i] + 1){ // ex. lost: 2, reserve: 4 -> 해당 lost의 경우 여벌을 빌려줄 수 없다. 다음 lost 원소로 넘어간다.
                        break;
                    }
                }
                j++;
            }
        }
        
        return answer;
    }
}
