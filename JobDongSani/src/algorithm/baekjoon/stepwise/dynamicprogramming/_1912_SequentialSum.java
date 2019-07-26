package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.Scanner;

public class _1912_SequentialSum {
    private static int N = 0;
    private static int[] sequence = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt(); scn.nextLine();
        sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = scn.nextInt();
        }
        // maxValue를 Integer.MIN_VALUE()로 두면 틀렸습니다.. 로 나옴. 왜 그렇지..
        // 반례
        // 2
        // -100 -200
        // 답은 -100이 나와야 하나, 내 소스에서는 -200이 나올 것
        // 맨 앞자리 수를 고려를 못 한 것임
        int maxValue = sequence[0];
//        int maxValue = Integer.MIN_VALUE;
        int[] dp = new int[N];
        dp[0] = sequence[0];
        for (int i = 1; i < N; i++) {
            int tmp = dp[i - 1] + sequence[i];
            int value = (tmp < sequence[i])? sequence[i] : tmp;
            dp[i] = value;
            if(maxValue < value){
                maxValue = value;
            }
        }
        if(N == 1){
            maxValue = dp[0];
        }
        System.out.println(maxValue);
        scn.close();
    }
}
