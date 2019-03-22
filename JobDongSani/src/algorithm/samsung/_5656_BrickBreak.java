package algorithm.samsung;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/samsung/_5656_BrickBreak.java
 *
 * ## brute force
 * 1. 벽돌을 표시할 2차원 int 배열 : bricks[h][w]
 * 2. n만큼 for문을 돌며, 0~w-1의 위치에 벽돌을 떨어뜨렸을 때의 결과를 List<int[][]> 에 넣는다.
 * 3. 깨트려진 벽돌을 표기하는 방법: 2차원 boolean 배열 broken[h][w]
 * 4. *제거되는 범위 내에 있는 벽돌은 동시에 제거된다.* 라는 조건 때문에 연쇄적인 brick 떨어짐을 고려할 필요는 없다.
 */
public class _5656_BrickBreak {
    private static int remainBricks(int[][] brick, int n, int w, int h){
        LinkedList<int[][]> stage = new LinkedList<>();
        stage.offer(brick);
        for (int i = 0; i < n; i++) {
            LinkedList<int[][]> tmpStage = new LinkedList<>();
            while(!stage.isEmpty()){
                int[][] tmp = stage.pop();
                for (int j = 0; j < w; j++) {
                    tmpStage.add(oneStep(tmp, w, h, j));
                }
            }
            stage.addAll(tmpStage);
        }

        int minRemains = w * h;
        for(int[][] result : stage){
            int remains = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(result[i][j] != 0){
                        remains++;
                    }
                }
            }
            if(minRemains > remains){
                minRemains = remains;
            }
        }
        return minRemains;
    }

    private static int[][] oneStep(int[][] brick, int w, int h, int wLocation){
        boolean[][] broken = new boolean[h][w];
        LinkedList<Integer> hs = new LinkedList<>();
        LinkedList<Integer> ws = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            if(brick[i][wLocation] != 0){
                hs.offer(i);
                ws.offer(wLocation);
                broken[i][wLocation] = true;
                break;
            }
        }

        while(!hs.isEmpty()){
            int hTmp = hs.pop();
            int wTmp = ws.pop();
            broken[hTmp][wTmp] = true;
            int breakNum = brick[hTmp][wTmp] - 1; // 자기자신 말고 추가적으로 부셔야 하는 범위
            if(breakNum != 0){
                int left = (wTmp - breakNum >= 0)? wTmp - breakNum : 0;
                int right = (wTmp + breakNum <= w - 1)? wTmp + breakNum : w - 1;
                int top = (hTmp - breakNum >= 0)? hTmp - breakNum : 0;
                int bottom = (hTmp + breakNum <= h - 1)? hTmp + breakNum : h - 1;
                for (int i = left; i <= right; i++) {
                    if(!broken[hTmp][i]){
                        hs.offer(hTmp);
                        ws.offer(i);
                        broken[hTmp][i] = true;
                    }
                }
                for (int i = top; i <= bottom; i++) {
                    if(!broken[i][wTmp]){
                        hs.offer(i);
                        ws.offer(wTmp);
                    }
                }
            }
        }

        // broken으로 깨진 벽돌을 확인하고, 떨어진 상태를 작업
        int[][] copy = new int[h][w];
        for (int i = 0; i < w; i++) {
            ArrayList<Integer> nonBroken = new ArrayList<>();
            for (int j = h - 1; j >= 0; j--) {
                if(brick[j][i] != 0 && !broken[j][i]){
                    nonBroken.add(j);
                }
                if(brick[j][i] == 0){
                    break;
                }
            }
            int end = h - 1;
            for(int left : nonBroken){
                copy[end--][i] = brick[left][i];
            }
        }
        return copy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        int n = 0, w = 0, h = 0, hFreq = 0;
        int[][] brick = null;
        while((str = br.readLine()) != null){
            if (testNum == 0) {
                testNum = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                if(h == 0){
                    n = Integer.parseInt(strArr[0]);
                    w = Integer.parseInt(strArr[1]);
                    h = Integer.parseInt(strArr[2]);
                    brick = new int[h][w];
                }else{
                    for (int i = 0; i < w; i++) {
                        brick[hFreq][i] = Integer.parseInt(strArr[i]);
                    }
                    hFreq++;
                    if(h == hFreq){
                        testFreq++;
//                        // brick에 제대로 들어갔는지 테스트
//                        StringBuilder sb = new StringBuilder();
//                        for (int i = 0; i < h; i++) {
//                            for (int j = 0; j < w; j++) {
//                                sb.append(brick[i][j]).append(" ");
//                            }
//                            sb.append("\n");
//                        }
//                        bw.write(sb.toString());
                        // 모든 처리 시작
                        int remains = remainBricks(brick, n, w, h);
                        bw.write("#" + String.valueOf(testFreq) + " " + String.valueOf(remains));
                        bw.newLine();
                        n = 0; w = 0; h = 0; hFreq = 0;
                        brick = null;
                        if(testFreq == testNum){
                            break;
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
