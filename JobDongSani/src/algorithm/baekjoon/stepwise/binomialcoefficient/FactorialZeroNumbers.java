package algorithm.baekjoon.stepwise.binomialcoefficient;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/binomialcoefficient/FactorialZeroNumbers.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 이항 계수 > 팩토리얼 0의 개수
 * 1. num: 0의 개수
 * 2. n!을 소인수분해 했을 때 10의 지수를 구하는 문제이다.
 * 3. 10 = 2 x 5 인데, n!에서 2의 갯수가 5의 갯수보다 많으므로 n!에서 5의 갯수를 찾으면 된다.
 * 4. 답은 [n! / 5] + [n! / 5^2] + [n! / 5^3] + ... 이다.
 */
public class FactorialZeroNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int num = 0;
            int i = 1;
            while(n > Math.pow(5, i)){
                num += (n / Math.pow(5, i++));
            }
            bw.write(String.valueOf(num));
            break;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
