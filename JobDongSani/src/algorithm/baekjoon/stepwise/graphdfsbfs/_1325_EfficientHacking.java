package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_1325_EfficientHacking.java
 *
 * ## 비대칭 그래프 & BFS
 * 1. 신뢰관계를 표기할 2차원 boolean 배열: confidence
 * 2. confidence[i][j]의 의미: i를 해킹하면 j도 해킹 가능
 * 3. confidence는 비대칭 matrix임 (confidence[i][j] != confidence[j][i])
 * 4. system input을 받으면서 confidence를 채운다. (j i -> confidence[i][j] = true)
 * 5. 1부터 n까지 for문을 돌며 bfs로 해킹가능한 컴퓨터 수를 세어나간다. (max 값 체크)
 * 6. 해킹가능한 컴퓨터 수를 저장할 1차원 int 배열: possibleNum
 * 7. possibleNum 의 원소 중 max 와 같은 것만을 오름차순으로 출력한다.
 */
public class _1325_EfficientHacking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, m = 0, mFreq = 0;
        boolean[][] confidence = null;
        int[] possibleNum = null;
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            if(n == 0) {
                n = Integer.parseInt(strArr[0]);
                m = Integer.parseInt(strArr[1]);
                confidence = new boolean[n + 1][n + 1]; // 1~n까지 번호의 컴퓨터 존재
                possibleNum = new int[n + 1];
            }else{
                confidence[Integer.parseInt(strArr[1])][Integer.parseInt(strArr[0])] = true;
                mFreq++;
                if(m == mFreq){
                    break;
                }
            }
        }

        int maxNodeNum = 0;
        for (int i = 1; i < n + 1; i++) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(i);
            boolean[] check = new boolean[n + 1];
            check[i] = true;
            int nodeNum = 0;
            while(!queue.isEmpty()){
                int node = queue.pop();
                for (int j = 1; j < n + 1; j++) {
                    if(node != j && !check[j] && confidence[node][j]){
                        queue.offer(j);
                        check[j] = true;
                        nodeNum++;
                    }
                }
            }
            if(maxNodeNum == 0 || maxNodeNum < nodeNum){
                maxNodeNum = nodeNum;
            }
            possibleNum[i] = nodeNum;
        }

        for (int i = 1; i < n + 1; i++) {
            if(possibleNum[i] == maxNodeNum){
                bw.write(String.valueOf(i) + " ");
            }
        }

//        // confidence가 제대로 기록되었는지 체크
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                bw.write(String.valueOf(confidence[i][j]) + " ");
//            }
//            bw.newLine();
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
