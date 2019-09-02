package programmers.skillchecktest1_2;

public class Problem2 {
    public double solution(int[] arr) {
        double answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer / arr.length;
    }
}
