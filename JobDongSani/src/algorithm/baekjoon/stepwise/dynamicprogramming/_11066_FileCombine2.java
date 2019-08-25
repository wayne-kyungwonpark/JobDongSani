package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.io.*;

public class _11066_FileCombine2 {
    private static int N = 0;
    private static int[] files = null;
    private static int[][] dp = null;
    private static int[][] sums = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(N == 0){
                    N = Integer.parseInt(str);
                    files = new int[N];
                    dp = new int[N][N];
                    sums = new int[N][N];
                }else{
                    String[] strArr = str.split(" ");
                    for (int i = 0; i < N; i++) {
                        files[i] = Integer.parseInt(strArr[i]);
                    }
                    doSomething();
                    sb.append(dp[0][N - 1]);
                    testFreq++;
                    if(testNum == testFreq){
                        break;
                    }else{
                        N = 0;
                        files = null;
                        dp = null;
                        sums = null;
                        sb.append("\n");
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // dp[j][i] : j부터 i번째까지 파일 합치기의 최솟값
    private static void doSomething() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                if(j == i){
                    dp[j][i] = 0;
                    sums[j][i] = files[i];
                }else{
                    sums[j][i] = sums[j][i - 1] + sums[i][i];
                    int minCost = 0;
                    for (int k = j; k <= i; k++) {
                        if (k == j){
                            minCost = dp[k + 1][i];
                        }else if(k == i){
                            minCost = Math.min(minCost, dp[j][k - 1]);
                        }else{
                            minCost = Math.min(minCost, dp[j][k] + dp[k + 1][i]);
                        }
                    }
                    dp[j][i] = minCost + sums[j][i];
                }
            }
        }
    }
}
