package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.Scanner;

// 다시 풀어야 함... dp 설계부터 잘못한 듯
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
        System.out.println(maxLength);
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
            int maxNum = 0;
            for (int i = start; i < end; i++) {
                for (int j = start; j <= i; j++) {
                    if(maxLength < longestLengths[j][i]){
                        maxLength = longestLengths[j][i];
                        maxNum = maxNums[j][i];
                    }else if(maxLength == longestLengths[j][i]){
                        if(maxNum == 0 || maxNum > maxNums[j][i]){
                            maxNum = maxNums[j][i];
                        }
                    }
                }
            }

            if(maxNum < sequence[end]){
                maxLength++;
                maxNum = sequence[end];
            }else{
                int secondMaxNum = 0;
                for (int i = start; i < end; i++) {
                    for (int j = start; j <= i; j++) {
                        if(longestLengths[j][i] == maxLength - 1){
                            if(secondMaxNum == 0 || secondMaxNum > maxNums[j][i]){
                                secondMaxNum = maxNums[j][i];
                            }
                        }
                    }
                }
                if(secondMaxNum < sequence[end]){
                    if(maxNum > sequence[end]){
                        maxNum = sequence[end];
                    }
                }
            }
            longestLengths[start][end] = maxLength;
            maxNums[start][end] = maxNum;
        }
    }
}
