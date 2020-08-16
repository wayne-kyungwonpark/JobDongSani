package algorithm.baekjoon.stepwise.lowestcommonancestor;

import java.io.*;

public class _17435_CompositeFunctionAndQuery2 {
    private static int m, Q;
    private static int[] f;
    private static int maxLevel;
    private static int[][] table; // sparse table

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(br.readLine());
        f = new int[m + 1];
        String[] strArr = br.readLine().split(" ");
        for (int i = 1; i <= m; i++) {
            f[i] = Integer.parseInt(strArr[i - 1]);
        }
        maxLevel = (int) (Math.log(500001) / Math.log(2)) + 1;
        table = new int[m + 1][maxLevel + 1];

        // sparse table 채우기
        for (int i = 1; i <= m; i++) {
            table[i][0] = f[i];
        }
        for (int i = 1; i <= maxLevel; i++) {
            for (int j = 1; j <= m; j++) {
                table[j][i] = table[table[j][i - 1]][i - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            int x = Integer.parseInt(strArr[1]);
            sb.append(solve(n, x)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solve(int n, int x){
        int current = x;
        for (int i = maxLevel; i >= 0; i--) {
            if((n & (1 << i)) != 0){
                current = table[current][i];
            }
        }
        return current;
    }
}
