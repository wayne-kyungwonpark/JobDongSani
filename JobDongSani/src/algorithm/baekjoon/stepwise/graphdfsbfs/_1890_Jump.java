package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_1890_Jump.java
 *
 * 1. (0,0)에서 (k,l)까지 가는 방법의 수를 저장할 이차원 int 배열: route[n][n] (k, l<=n-1)
 * 2. (0,0)부터 for문을 돌며 route를 계산한다.
 * 3. route[k][l] = sum(route[k][.]) + sum(route[.][l])
 */
public class _1890_Jump {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0;
        int nFreq = 0;
        int[][] board = null;
        while((str = br.readLine()) != null){
            if(n == 0){
                n = Integer.parseInt(str);
                board = new int[n][n];
            }else{
                String[] strArr = str.split(" ");
                for (int i = 0; i < strArr.length; i++) {
                    board[nFreq][i] = Integer.parseInt(strArr[i]);
                }
                nFreq++;
                if(n == nFreq){
                    break;
                }
            }
        }
        long[][] route = new long[n][n];
        route[0][0] = 1l;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != 0 || j != 0){
                    long value = 0;
                    for (int k = 0; k < j; k++) {//i, j 기준으로 왼쪽 체크
                        if(board[i][k] + k == j){
                            value += route[i][k];
                        }
                    }
                    for (int k = 0; k < i; k++) {//i, j 기준으로 위쪽 체크
                        if(board[k][j] + k == i){
                            value += route[k][j];
                        }
                    }
                    route[i][j] = value;
                }
            }
        }
        bw.write(String.valueOf(route[n - 1][n - 1]));

//        LinkedList<Integer> rowQueue = new LinkedList<>();
//        LinkedList<Integer> colQueue = new LinkedList<>();
//        long routeNum = 0;
//        rowQueue.push(0);
//        colQueue.push(0);
//        int endRow = n - 1;
//        int endCol = n - 1;
//        while(!rowQueue.isEmpty()){
//            int row = rowQueue.pop();
//            int col = colQueue.pop();
//            int value = board[row][col];
//            if(row + value <= endRow){
//                if(row + value == endRow && col == endCol){
//                    routeNum++;
//                }else{
//                    rowQueue.push(row + value);
//                    colQueue.push(col);
//                }
//            }
//            if(col + value <= endCol){
//                if(row == endRow && col + value == endCol){
//                    routeNum++;
//                }else{
//                    rowQueue.push(row);
//                    colQueue.push(col + value);
//                }
//            }
//        }
//        bw.write(String.valueOf(routeNum));

//        // board가 제대로 채워졌는지 체크
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                bw.write(String.valueOf(board[i][j]) + " ");
//            }
//            bw.newLine();
//        }

        bw.flush();
        bw.close();
        br.close();
    }
}
