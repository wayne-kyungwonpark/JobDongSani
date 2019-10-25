package programmers.comcom;

public class Problem2Test {
    public static void main(String[] args) {
        Problem2 p2 = new Problem2();
        int[] truck = {1,4,5,2,4};
        int[] w = {2,4,4,3,2};
        int[] answer = p2.solution(truck, w);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
