package brandi.secondround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    private static int N, d;
    private static int[][] mines = null;
    private static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static boolean[][] visit = null;
    private static int maxD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Nd = br.readLine().split(" ");
        N = Integer.parseInt(Nd[0]);
        d = Integer.parseInt(Nd[1]);
        mines = new int[N][N];
        visit = new boolean[N][N];
        maxD = -1;
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                mines[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        visit[0][0] = true;
        dfs(0, 0, d);

        System.out.println(maxD);
    }

    private static void dfs(int startR, int startC, int reserve){
        int newReserve = reserve - mines[startR][startC];
        if(startR == N - 1 && startC == N - 1){
            maxD = Math.max(maxD, newReserve);
            return;
        }
        if(newReserve < 0){
            return;
        }
        for (int i = 0; i < move.length; i++) {
            int nextR = startR + move[i][0];
            int nextC = startC + move[i][1];
            if(nextR >= 0 && nextR <= N - 1 && nextC >= 0 && nextC <=N - 1 && !visit[nextR][nextC]){
                visit[nextR][nextC] = true;
                dfs(nextR, nextC, newReserve);
                visit[nextR][nextC] = false;
            }
        }
    }
}
