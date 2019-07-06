package algorithm.baekjoon.stepwise.bruteforce;

import java.io.*;

public class _1018_ChessBoardReColoring {
    private static char[][] WBoard = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
    };
    private static char[][] BBoard = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };
    private static int minReColoringNum = Integer.MAX_VALUE;
    private static char[][] MNBoard = null;
    private static int N = 0, M = 0;

    private static void check(int rStart, int cStart){
        if(N - rStart < 8 || M - cStart < 8){
            return;
        }
        int checkWithWBoard = 0, checkWithBBoard = 0;
        for (int i = 0; i < 8; i++) {
            int row = i + rStart;
            for (int j = 0; j < 8; j++) {
                if(WBoard[i][j] != MNBoard[row][j + cStart]){
                    checkWithWBoard++;
                }else{
                    checkWithBBoard++;
                }
            }
        }
        int reColoringNum = Math.min(checkWithBBoard, checkWithWBoard);
        if(reColoringNum < minReColoringNum){
            minReColoringNum = reColoringNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int nFreq = 0;
        while((str = br.readLine()) != null){
            if(N == 0){
                String[] strArr = str.split(" ");
                N = Integer.parseInt(strArr[0]); M = Integer.parseInt(strArr[1]);
                MNBoard = new char[N][M];
            }else{
                MNBoard[nFreq] = str.toCharArray();
                nFreq++;
                if(N == nFreq){
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check(i, j);
                if(minReColoringNum == 0){
                    break;
                }
            }
            if(minReColoringNum == 0){
                break;
            }
        }
        bw.write(String.valueOf(minReColoringNum));
        bw.flush();
        bw.close();
        br.close();
    }
}
