package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.Scanner;

public class _11053_LongestIncrementSubSequence {
    private static int N = 0;
    private static int[] sequence = null;
    private static int[][] longestLengths = null;
    private static int[][] maxNums = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt(); scn.nextLine();
        sequence = new int[N];
        // longestLengths[i][j] : 수열의 i번째 수부터 j번째 수까지 가장 긴 증가하는 부분수열의 길이
        longestLengths = new int[N][N];
        // maxNums[i][j] : 수열의 i번째 수부터 j번째 수까지 가장 긴 증가하는 부분수열의 가장 큰 수
        maxNums = new int[N][N];
        for (int i = 0; i < N; i++) {
            sequence[i] = scn.nextInt();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                findLongestlengths(j, i);
            }
        }
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if(longestLengths[i][N - 1] > maxLength){
                maxLength = longestLengths[i][N - 1];
            }
        }
        System.out.println(longestLengths[0][N - 1]);
        scn.close();
    }

    private static void findLongestlengths(int start, int end){
        if(start > N - 1 || end > N - 1){
            return;
        }
        if(start > end){
            return;
        }
        if(start == end){
            longestLengths[start][end] = 1;
            maxNums[start][end] = sequence[end];
        }else{
            int maxLength = 1;
            int maxNum = sequence[end];
            for (int i = start; i < end; i++) {
                if(maxNums[i][end - 1] < sequence[end]){
                    if(maxLength < longestLengths[i][end - 1] + 1){
                        maxLength = longestLengths[i][end - 1] + 1;
                        maxNum = sequence[end];
                    }else{
                        if(maxNum < maxNums[i][end - 1]){
                            maxNum = maxNums[i][end - 1];
                        }
                    }
                }
            }
            longestLengths[start][end] = maxLength;
            maxNums[start][end] = maxNum;
        }
    }
}
