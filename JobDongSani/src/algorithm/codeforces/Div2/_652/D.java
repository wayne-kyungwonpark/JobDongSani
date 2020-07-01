package algorithm.codeforces.Div2._652;

import java.io.*;
import java.math.BigInteger;

public class D {
    private static long[] dp = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] number = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            number[i] = Integer.parseInt(br.readLine());
            if(number[i] > max){
                max = number[i];
            }
        }
        maximum(max);
        for (int i = 0; i < number.length; i++) {
            sb.append(dp[number[i]]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void maximum(int level){
        int mod = (int) Math.pow(10, 9) + 7;
        dp = new long[level + 3];
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 4;

        for (int i = 4; i <= level; i++) {
            dp[i] = dp[i - 2] * 2 + dp[i - 1];
            if(i % 3 == 0){
                dp[i] += 4;
            }
            dp[i] %= mod;
        }
    }
}
