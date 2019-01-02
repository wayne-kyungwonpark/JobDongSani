package algorithm.baekjoon.stepwise.binomialcoefficient;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/binomialcoefficient/Factorial.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 이항 계수 > 팩토리얼
 * 1. for문을 돌며 읽어온 숫자에 대한 factorial 연산을 수행한다.
 */
public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int facVal = 1;
            for (int i = 1; i <= n ; i++) {
                facVal *= i;
            }
            bw.write(String.valueOf(facVal));
            break;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
