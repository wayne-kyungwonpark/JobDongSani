package startupcodingfestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] clothes = new int[M][N];
        long[] dp1 = new long[N];
        long[] dp2 = new long[N];
        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                clothes[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        dp1[0] = clothes[0][0];
        for (int i = 1; i < N; i++) {
            dp1[i] = dp1[i - 1] + clothes[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(j == 0){
                    dp2[j] = dp1[j] + clothes[i][j];
                }else{
                    dp2[j] = Math.max(dp2[j - 1], dp1[j]) + clothes[i][j];
                }
            }
            dp1 = dp2;
            dp2 = new long[N];
        }

        System.out.println(dp1[N - 1]);
    }
}
