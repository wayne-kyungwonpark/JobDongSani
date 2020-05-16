package naver.financial;

public class Solution1 {
    public static void main(String[] args) {
        solution(10);
    }

    public static void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 100 != 0) { // changed part 1 : check whether the next digit is 0
                enable_print = 1;
            }
            else if (enable_print != 0) { // change part 2 : check whether the present digit is 0
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }
}
