package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_10216_CountCircleGroups.java
 *
 * ## 그래프 및 BFS
 * 1. 적군 진영의 x, y, r을 저장할 1차원 int 배열 3개: x, y, r
 * 2. 적군 진영의 1대1 커넥션을 표기할 2차원 boolean 배열: connection
 * 3. connection에 대해 for문을 돌며 bfs로 grouping 체크를 한다.
 * 4. 어떠한 그룹에 이미 소속된 적군 진영을 표기할 1차원 boolean 배열: check
 */
public class _10216_CountCircleGroups {
    private static boolean isConnected(int x1, int y1, int r1, int x2, int y2, int r2){
        double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        if(Double.compare(dist, r1 + r2) <= 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        int enemyNum = 0, enemyFreq = 0;
        int[] x = null, y = null, r = null;
        boolean[] check = null;
        boolean[][] connection = null;
        int[] answer = null;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
                answer = new int[testNum];
            }else{
                if(enemyNum == 0){
                    enemyNum = Integer.parseInt(str);
                    x = new int[enemyNum]; y = new int[enemyNum]; r = new int[enemyNum];
                    check = new boolean[enemyNum];
                    connection = new boolean[enemyNum][enemyNum];
                }else{
                    String[] strArr = str.split(" ");
                    x[enemyFreq] = Integer.parseInt(strArr[0]); y[enemyFreq] = Integer.parseInt(strArr[1]); r[enemyFreq] = Integer.parseInt(strArr[2]);
                    enemyFreq++;
                    if(enemyNum == enemyFreq){
                        // 처리할 곳
                        for (int i = 0; i < enemyNum; i++) {
                            for (int j = i; j < enemyNum; j++) {
                                if(i != j){
                                    if(isConnected(x[i], y[i], r[i], x[j], y[j], r[j])){
                                        connection[i][j] = true;
                                        connection[j][i] = true;
                                    }
                                }
                            }
                        }
                        int groups = 0;
                        for (int i = 0; i < enemyNum; i++) {
                            if(!check[i]){
                                //bfs
                                LinkedList<Integer> queue = new LinkedList<>();
                                queue.offer(i);
                                check[i] = true;
                                while(!queue.isEmpty()){
                                    int node = queue.pop();
                                    for (int j = 0; j < enemyNum; j++) {
                                        if(!check[j] && connection[node][j]){
                                            queue.offer(j);
                                            check[j] = true;
                                        }
                                    }
                                }
                                groups++;
                            }
                        }
                        answer[testFreq] = groups;
                        testFreq++;
                        if(testFreq == testNum){
                            break;
                        }else{
                            enemyNum = 0;
                            enemyFreq = 0;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            bw.write(String.valueOf(answer[i]));
            if(i != answer.length - 1){
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
