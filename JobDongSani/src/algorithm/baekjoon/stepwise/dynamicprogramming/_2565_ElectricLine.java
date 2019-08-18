package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2565_ElectricLine {
    private static int N = 0;
    private static int[][] lines = null;
    private static int[][] tmps = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int nFreq = 0;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                lines = new int[N][2];
                tmps = new int[N][2];
            }else{
                String[] strArr = str.split(" ");
                lines[nFreq][0] = Integer.parseInt(strArr[0]);
                lines[nFreq][1] = Integer.parseInt(strArr[1]);
                nFreq++;
                if(N == nFreq){
                    break;
                }
            }
        }
        merge(0, N - 1, 0);
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(lines[i][1] > lines[j][1]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        System.out.println(N - max);
    }

    private static void merge(int start, int end, int index){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(lines[start][index] > lines[end][index]){
                int tmpIndex = lines[start][index], tmpNonIndex = lines[start][1 - index];
                lines[start][index] = lines[end][index];
                lines[start][1 - index] = lines[end][1 - index];
                lines[end][index] = tmpIndex;
                lines[end][1 - index] = tmpNonIndex;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid, index);
        merge(mid + 1, end, index);
        int left = start, right = mid + 1, k = start;
        while(left <= mid && right <= end){
            if(lines[left][index] < lines[right][index]){
                tmps[k][index] = lines[left][index];
                tmps[k][1 - index] = lines[left][1 - index];
                left++;
            }else{
                tmps[k][index] = lines[right][index];
                tmps[k][1 - index] = lines[right][1 - index];
                right++;
            }
            k++;
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmps[k][index] = lines[i][index];
                tmps[k][1 - index] = lines[i][1 - index];
                k++;
            }
        }else{
            for (int i = left; i <= mid; i++) {
                tmps[k][index] = lines[i][index];
                tmps[k][1 - index] = lines[i][1 - index];
                k++;
            }
        }
        for (int i = start; i <= end; i++) {
            lines[i][index] = tmps[i][index];
            lines[i][1 - index] = tmps[i][1 - index];
        }
    }
}
