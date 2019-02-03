package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_2178_Maze.java
 *
 * 1. 미로를 표현할 2차원 boolean 배열: maze[N+1][M+1]
 * 2. bfs에서 node를 체크할 2차원 boolean 배열: check[N+1][M+1]
 * 3. 미로의 row와 column을 넣을 queue: rowQueue, colQueue (bfs 사용)
 * 4. 지나야 하는 최소 칸 수: value
 * 5. 그래프의 depth를 찾기 위한 lastNode[2]
 */
public class _2178_Maze {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, m = 0, nFreq = 0;
        boolean[][] maze = null;
        while((str = br.readLine()) != null){
            if(n == 0){
                String[] strArr = str.split(" ");
                n = Integer.parseInt(strArr[0]);
                m = Integer.parseInt(strArr[1]);
                maze = new boolean[n + 1][m + 1];
            }else{
                nFreq++;
                char[] chArr = str.toCharArray();
                for (int i = 1; i <= m; i++) {
                    if('1' == chArr[i - 1]){
                        maze[nFreq][i] = true;
                    }
                }
                if(nFreq == n){
                    break;
                }
            }
        }
        boolean[][] check = new boolean[n + 1][m + 1];
        LinkedList<Integer> rowQueue = new LinkedList<>();
        LinkedList<Integer> colQueue = new LinkedList<>();
        check[n][m] = true;
        rowQueue.offer(n);
        colQueue.offer(m);
        int value = 1;
        int[] lastNode = new int[2];
        lastNode[0] = n; lastNode[1] = m;
        while(!rowQueue.isEmpty()){
            int row = rowQueue.pop();
            int col = colQueue.pop();
            if(row == 1 && col == 1){
                break;
            }
            if(row != 1 && maze[row - 1][col] && !check[row - 1][col]){//위
                rowQueue.offer(row - 1);
                colQueue.offer(col);
                check[row - 1][col] = true;
            }
            if(col != 1 && maze[row][col - 1] && !check[row][col - 1]){//왼
                rowQueue.offer(row);
                colQueue.offer(col - 1);
                check[row][col - 1] = true;
            }
            if(row != n && maze[row + 1][col] && !check[row + 1][col]){//아래
                rowQueue.offer(row + 1);
                colQueue.offer(col);
                check[row + 1][col] = true;
            }
            if(col != m && maze[row][col + 1] && !check[row][col + 1]) {//오
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
//        // maze 변환이 제대로 되었는지 체크
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                bw.write(String.valueOf(maze[i][j]) + " ");
//            }
//            bw.newLine();
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
