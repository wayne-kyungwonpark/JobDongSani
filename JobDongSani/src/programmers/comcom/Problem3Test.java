package programmers.comcom;

public class Problem3Test {
    public static void main(String[] args) {
        Problem3 p3 = new Problem3();
        int[] grade = {3,2,1,2};
        int[] answer = p3.solution(grade);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
