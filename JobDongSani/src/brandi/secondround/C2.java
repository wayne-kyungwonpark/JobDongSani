package brandi.secondround;

import java.io.*;

public class C2 {
    private static int maxValue = 1000000;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ctest.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] Nk = br.readLine().split(" ");
        int N = Integer.parseInt(Nk[0]);
        int k = Integer.parseInt(Nk[1]);
        int[] strengths = new int[N];

        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            strengths[i] = Integer.parseInt(strArr[i]);
        }

        long[][] dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            int[] freqs = new int[maxValue + 1];
            for (int j = i; j < N; j++) {
                freqs[strengths[j]]++;
                dp[i][j] = (long) freqs[strengths[j]] * strengths[j];
                if(j != i){
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        for (int i = 0; i < k; i++) {
            String[] lr = br.readLine().split(" ");
            sb.append(dp[Integer.parseInt(lr[0]) - 1][Integer.parseInt(lr[1]) - 1]);
            if(i != k - 1){
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
