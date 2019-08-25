package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.Scanner;

public class _9251_LongestCommonSubsequence {
    private static char[] seq1 = null;
    private static char[] seq2 = null;
    private static int[][] dp = null;
    private static int[][] partialMax = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        seq1 = scn.nextLine().toCharArray();
        seq2 = scn.nextLine().toCharArray();
        // dp[i][j] : seq1[i], seq2[j] 가 포함되는 가장 긴 공통 부분수열의 길이
        dp = new int[seq1.length][seq2.length];
        partialMax = new int[seq1.length][seq2.length];

        int ans = 0;
        for (int i = 0; i < seq1.length; i++) {
            for (int j = 0; j < seq2.length; j++) {
                if(seq1[i] == seq2[j]){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                        partialMax[i][j] = 1;
                    }else{
                        dp[i][j] = partialMax[i - 1][j - 1] + 1;
                        partialMax[i][j] = dp[i][j];
                    }
                }else{
                    if(i != 0 && j != 0){
                        partialMax[i][j] = Math.max(partialMax[i][j - 1], partialMax[i - 1][j]);
                    }else if(i != 0 && j == 0){
                        partialMax[i][j] = partialMax[i - 1][j];
                    }else if(i == 0 && j != 0){
                        partialMax[i][j] = partialMax[i][j - 1];
                    }
                }
                if(dp[i][j] > ans){
                    ans = dp[i][j];
                }
            }
        }
        System.out.println(ans);
        scn.close();
    }
}
