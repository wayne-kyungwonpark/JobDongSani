package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.LinkedList;

public class _1012_OrganicCabbage {
    private static boolean[][] farm = null;
    private static boolean[][] checks = null;
    private static int M = 0, N = 0, K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0, kFreq = 0;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                if(M == 0){
                    M = Integer.parseInt(strArr[0]);
                    N = Integer.parseInt(strArr[1]);
                    K = Integer.parseInt(strArr[2]);
                    farm = new boolean[N][M];
                    checks = new boolean[N][M];
                }else{
                    int col = Integer.parseInt(strArr[0]);
                    int row = Integer.parseInt(strArr[1]);
                    farm[row][col] = true;
                    kFreq++;
                    if(kFreq == K){
                        sb.append(doSomething());
                        testFreq++;
                        if(testFreq == testNum){
                            break;
                        }else{
                            sb.append("\n");
                            N = 0; M = 0; K = 0; kFreq = 0;
                            farm = null; checks = null;
                        }
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int doSomething() {
        int groupNums = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(farm[i][j] && !checks[i][j]){ // 배추가 심어져 있으면서 체크가 되지 않은 땅
                    groupNums++;
                    bfs(i, j);
                }
            }
        }
        return groupNums;
    }

    private static void bfs(int row, int col) {
        LinkedList<Integer> rows = new LinkedList<>();
        LinkedList<Integer> cols = new LinkedList<>();
        rows.add(row);
        cols.add(col);
        checks[row][col] = true;
        while(!rows.isEmpty()){
            int tmpRow = rows.removeFirst();
            int tmpCol = cols.removeFirst();
            // 위쪽 추가
            if(tmpRow != 0 && farm[tmpRow - 1][tmpCol] && !checks[tmpRow - 1][tmpCol]){
                rows.add(tmpRow - 1);
                cols.add(tmpCol);
                checks[tmpRow - 1][tmpCol] = true;
            }
            // 아래쪽 추가
            if(tmpRow != N - 1 && farm[tmpRow + 1][tmpCol] && !checks[tmpRow + 1][tmpCol]){
                rows.add(tmpRow + 1);
                cols.add(tmpCol);
                checks[tmpRow + 1][tmpCol] = true;
            }
            // 왼쪽 추가
            if(tmpCol != 0 && farm[tmpRow][tmpCol - 1] && !checks[tmpRow][tmpCol - 1]){
                rows.add(tmpRow);
                cols.add(tmpCol - 1);
                checks[tmpRow][tmpCol - 1] = true;
            }
            // 오른쪽 추가
            if(tmpCol != M - 1 && farm[tmpRow][tmpCol + 1] && !checks[tmpRow][tmpCol + 1]){
                rows.add(tmpRow);
                cols.add(tmpCol + 1);
                checks[tmpRow][tmpCol + 1] = true;
            }
        }
    }
}
