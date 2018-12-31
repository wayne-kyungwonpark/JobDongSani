package algorithm.baekjoon.stepwise.binomialcoefficient;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/binomialcoefficient/BinomialCoefficient1.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 이항 계수 > 이항 계수 1
 * 1. n, k를 뽑아낸다.
 * 2. k > n - k 일 경우 n - k를 k로 설정한다. (5C4 -> 5C1)
 * 3. 분자, 분모를 for문 돌며 계산한다. k = 0일 경우는 1로 대체한다.
 */
public class BinomialCoefficient1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = null;
        int n = 0, k = 0;
        while ((str = br.readLine()) != null) {
            String[] strArr = str.split(" ");
            n = Integer.parseInt(strArr[0]);
            k = Integer.parseInt(strArr[1]);
            break;
        }
        if (k > n - k) {
            k = n - k;
        }
        int numerator = 1;
        int denominator = 1;
        if (k == 0) {
            bw.write("1");
        } else {
            for (int i = 0; i < k; i++) {
                numerator *= n - i;
                denominator *= k - i;
            }
            bw.write(String.valueOf(numerator / denominator));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
