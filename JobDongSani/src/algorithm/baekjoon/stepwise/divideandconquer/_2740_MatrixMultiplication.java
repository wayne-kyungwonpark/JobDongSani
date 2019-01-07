package algorithm.baekjoon.stepwise.divideandconquer;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/divideandconquer/_2740_MatrixMultiplication.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 분할 정복 > 행렬 곱셈
 * 1. n: 행, n: 열, A: n x m 행렬, B: m x n 행렬
 * 2. A, B에 값을 저장한 후, 계산해준다.
 * 3. 결과값은 result 에 저장된다.
 */
public class _2740_MatrixMultiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, m = 0;
        int nFreq = 0, mFreq = 0;
        int[][] A = null, B = null;
        int caseNum = 0;
        while((str = br.readLine()) != null) {
            if (caseNum == 0) {
                String[] strArr = str.split(" ");
                n = Integer.parseInt(strArr[0]);
                m = Integer.parseInt(strArr[1]);
                A = new int[n][m];
                B = new int[m][n];
                caseNum = 1;
            } else if (nFreq == n && caseNum == 1) {
                nFreq = 0;
                mFreq = 0;
                caseNum = 2;
            }else if(caseNum == 1){
                String[] strArr = str.split(" ");
                for (int i = 0; i < m; i++) {
                    A[nFreq][i] = Integer.parseInt(strArr[i]);
                }
                nFreq++;
            }else{
                String[] strArr = str.split(" ");
                for (int i = 0; i < n; i++) {
                    B[mFreq][i] = Integer.parseInt(strArr[i]);
                }
                mFreq++;
            }
            if(mFreq == m && caseNum == 2){
                break;
            }
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(String.valueOf(result[i][j]) + " ");
            }
            if(i != n - 1){
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
