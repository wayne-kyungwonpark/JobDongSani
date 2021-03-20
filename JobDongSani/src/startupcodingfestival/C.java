package startupcodingfestival;

import java.io.*;

public class C {
    private static boolean[][] dp = null;
    private static long[] values = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] spaces = new char[N][N];
        dp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            spaces[i] = br.readLine().toCharArray();
        }
        long total = 0;
        values = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            values[i] = valuesPerSize(i, spaces);
            total += values[i];
            if(values[i] == 0){
                break;
            }
        }

        sb.append("total: ").append(total).append("\n");
        for (int i = 1; i <= N; i++) {
            if(values[i] != 0){
                sb.append("size[").append(i).append("]: ").append(values[i]).append("\n");
            }else{
                break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long valuesPerSize(int size, char[][] spaces){
        long result = 0;
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces.length; j++) {
                if(isPossible(i, j, size, spaces)){
                    result++;
                    dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return result;
    }


    private static boolean isPossible(int r, int c, int size, char[][] spaces){
        if(spaces[r][c] == '0' || (size != 1 && !dp[r][c])){
            return false;
        }

        if(r + size > spaces.length || c + size > spaces.length){
            return false;
        }

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(spaces[i][j] == '0'){
                    return false;
                }
            }
        }

        return true;
    }
}
