package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.Scanner;

public class _11053_LongestIncrementSubSequence {
    private static int N = 0;
    private static int[] sequence = null;
    private static int[] dp = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt(); scn.nextLine();
        sequence = new int[N];
        // dp[i] : 수열의 i번째 수가 부분 수열의 가장 큰 수일 때, 해당 부분수열의 최대 길이
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = scn.nextInt();
            dp[i] = 1;
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(sequence[i] > sequence[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if(dp[i] > maxLength){
                maxLength = dp[i];
            }
        }
        System.out.println(maxLength);
        scn.close();
    }
}
