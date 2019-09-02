package programmers.skillchecktest1;

public class Problem2Test {
    public static void main(String[] args) {
        int n = 10;
        int[] lost = {1, 3, 5, 7, 9};
        int[] reserve = {1, 3, 5, 7, 9};
        Problem2 p2 = new Problem2();
        System.out.println(p2.solution(n, lost, reserve));
    }
}
