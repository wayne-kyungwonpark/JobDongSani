package algorithm.baekjoon.stepwise.binomialcoefficient;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/binomialcoefficient/BinomialCoefficient2.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 이항 계수 > 이항 계수 2
 * 1. n, k를 뽑아낸다.
 * 2. n + 1, n + 1 짜리 int 배열을 만들고 동적계획법으로 1C0, 1C1부터 차례차례 채워나간다.
 * 3. 채우는 방법은 nCk = (n-1)C(k-1) + (n-1)C(k)
 * 4. n, k 일때의 배열값을 출력한다.
 */
public class BinomialCoefficient2 {

    private static int[][] binomialCoefficients;
    private static final int MOD = 10007;

    private static void makeBC(int n, int k) {
        binomialCoefficients = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    binomialCoefficients[i][j] = 1;
                }else{
                    binomialCoefficients[i][j] = (binomialCoefficients[i - 1][j - 1] + binomialCoefficients[i - 1][j]) % MOD;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, k = 0;
        while ((str = br.readLine()) != null) {
            String[] strArr = str.split(" ");
            n = Integer.parseInt(strArr[0]);
            k = Integer.parseInt(strArr[1]);
            break;
        }
        makeBC(n, k);
        bw.write(String.valueOf(binomialCoefficients[n][k]));
        bw.flush();
        bw.close();
        br.close();
    }
}
