package algorithm.codeforces.Div2._652;

import java.io.*;
import java.math.BigInteger;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.append(maximum(Integer.parseInt(br.readLine()))).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

//    private static long maximum(int level){
//        BigInteger[] dp = new BigInteger[level + 3];
//        dp[1] = new BigInteger("0");
//        dp[2] = new BigInteger("0");
//        dp[3] = new BigInteger("4");
//        for (int i = 4; i <= level; i++) {
//            BigInteger includeRoot = new BigInteger("4").add(dp[i - 3].multiply(new BigInteger("4"))).add(dp[i - 2]);
//            BigInteger excludeRoot = dp[i - 2].multiply(new BigInteger("2")).add(dp[i - 1]);
//            if(includeRoot.compareTo(excludeRoot) < 0){
//                dp[i] = excludeRoot;
//            }else{
//                dp[i] = includeRoot;
//            }
//        }
//
//        return dp[level].mod(new BigInteger("1000000007")).intValue();
//    }

    private static long maximum(int level){
        int mod = (int) Math.pow(10, 9) + 7;
        long[] dp = new long[level + 3];
        int[] lengthDp = new int[level + 3];
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 4;
        lengthDp[1] = 1;
        lengthDp[2] = 1;
        lengthDp[3] = 1;

        for (int i = 4; i <= level; i++) {
            int length1 = (int) Math.log10(dp[i - 2] * 2 + dp[i - 1]) + 1;
            int length2 = (int) Math.log10(dp[i - 3] * 4 + dp[i - 2] + 4) + 1;
            if(length1 > length2){
                dp[i] = dp[i - 2] * 2 + dp[i - 1];
            }else{
                dp[i] = dp[i - 3] * 4 + dp[i - 2] + 4;
            }
//            dp[i] = Math.max(dp[i - 2] * 2 + dp[i - 1], dp[i - 3] * 4 + dp[i - 2] + 4);

        }

        return dp[level] % mod;
    }

    private static long ans(long num, int mod){
        return num % mod;
    }
}
