package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_7576_Tomato.java
 *
 * _7569_Tomato.java 의 한 차원 아래 버전
 * 해당 소스의 풀이 참고
 */
public class _7576_Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int m = 0, n = 0;
        int nFreq = 0;
        int[][] tomato = null;
        while ((str = br.readLine()) != null){
            if(n == 0){
                String[] strArr = str.split(" ");
                m = Integer.parseInt(strArr[0]);
                n = Integer.parseInt(strArr[1]);
                tomato = new int[n + 2][m + 2];
                for (int i = 0; i < n + 2; i++) {
                    tomato[i][0] = -1;
                    tomato[i][m + 1] = -1;
                }
                for (int i = 0; i < m + 2; i++) {
                    tomato[0][i] = -1;
                    tomato[n + 1][i] = -1;
                }
            }else{
                String[] strArr = str.split(" ");
                nFreq++;
                for (int i = 1; i <= m; i++) {
                    tomato[nFreq][i] = Integer.parseInt(strArr[i - 1]);
                }
                if(nFreq == n){
                    break;
                }
            }
        }

        boolean isPossible = true;
        boolean isAlreadyRipen = true;
        List<Integer> is = new ArrayList<>();
        List<Integer> js = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(tomato[i][j] == 0){
                    if(tomato[i-1][j] == -1 && tomato[i+1][j] == -1
                    && tomato[i][j-1] == -1 && tomato[i][j+1] == -1){
                        isPossible = false;
                    }
                    isAlreadyRipen = false;
                }else if(tomato[i][j] == 1){
                    is.add(i);
                    js.add(j);
                }
            }
        }

        if(!isPossible){
            bw.write("-1");
        }else if(isAlreadyRipen){
            bw.write("0");
        }else{
            LinkedList<Integer> rowQueue = new LinkedList<>();
            LinkedList<Integer> colQueue = new LinkedList<>();
            boolean[][] check = new boolean[n + 2][m + 2];
            for (int i = 0; i < is.size(); i++) {
                rowQueue.offer(is.get(i));
                colQueue.offer(js.get(i));
                check[is.get(i)][js.get(i)] = true;
            }
            int[] lastNode = new int[2];
            lastNode[0] = is.get(is.size() - 1);
            lastNode[1] = js.get(js.size() - 1);
            int value = 0;
            while(!rowQueue.isEmpty()){
                int row = rowQueue.pop();
                int col = colQueue.pop();
                if(tomato[row - 1][col] == 0 && !check[row - 1][col]){//위
                    rowQueue.offer(row - 1);
                    colQueue.offer(col);
                    check[row - 1][col] = true;
                }
                if(tomato[row + 1][col] == 0 && !check[row + 1][col]){//아래
                    rowQueue.offer(row + 1);
                    colQueue.offer(col);
                    check[row + 1][col] = true;
                }
                if(tomato[row][col - 1] == 0 && !check[row][col - 1]){//왼
                    rowQueue.offer(row);
                    colQueue.offer(col - 1);
                    check[row][col - 1] = true;
                }
                if(tomato[row][col + 1] == 0 && !check[row][col + 1]){//오른
                    rowQueue.offer(row);
                    colQueue.offer(col + 1);
                    check[row][col + 1] = true;
                }
                if(row == lastNode[0] && col == lastNode[1]){
                    if(!rowQueue.isEmpty()){
                        value++;
                        lastNode[0] = rowQueue.get(rowQueue.size() - 1);
                        lastNode[1] = colQueue.get(colQueue.size() - 1);
                    }
                }
            }
            bw.write(String.valueOf(value));
        }

//        // tomato가 배열에 잘 들어갔는지 체크
//        for (int i = 0; i < n + 2; i++) {
//            for (int j = 0; j < m + 2; j++) {
//                bw.write(String.valueOf(tomato[i][j]) + " ");
//            }
//            bw.newLine();
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
