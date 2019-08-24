package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11049_MatrixMultiplicationOrder {
    private static int N = 0;
    private static int[][] matrix = null;
    private static int[][] dp = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int nFreq = 0;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                matrix = new int[N][2];
                dp = new int[N][N];
            }else{
                String[] strArr = str.split(" ");
                matrix[nFreq][0] = Integer.parseInt(strArr[0]);
                matrix[nFreq][1] = Integer.parseInt(strArr[1]);
                nFreq++;
                if(N == nFreq){
                    break;
                }
            }
        }
        // dp[j][i] : j 번째부터 i 번째까지 곱했을 때의 연산 최소 횟수
        dp[0][1] = matrix[0][0] * matrix[1][0] * matrix[1][1];
        for (int i = 2; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(j == i - 1){
                    dp[j][i] = matrix[j][0] * matrix[i][0] * matrix[i][1];
                }else{
                    // dp[j][i] = min([j, (j + 1, i)], [(j, j + 1), (j + 2, i)], ..., [(j, i - 2), (i - 1, i)], [(j, i - 1), i])
                    for (int k = i; k >= j; k--) {
                        if(k == i){
                            dp[j][i] = dp[j][i - 1] + matrix[j][0] * matrix[i][0] * matrix[i][1];
                        }else{
                            if(k != j){
                                dp[j][i] = Math.min(dp[j][i], dp[j][k - 1] + dp[k][i] + matrix[j][0] * matrix[k][0] * matrix[i][1]);
                            }else{
                                dp[j][i] = Math.min(dp[j][i], dp[j + 1][i] + matrix[j][0] * matrix[j + 1][0] * matrix[i][1]);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[0][N - 1]);
        br.close();
    }
}
