package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_2606_Virus.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 그래프 (DFS, BFS) > 바이러스
 * 0. BFS를 통해 풀이
 * 1. 그래프를 표기할 boolean 2차원 배열 생성: graph
 * 2. graph[i][j] = true if 간선 i - j exists (graph[i][i] = false)
 * 3. 감염된 컴퓨터 표기할 boolean 1차원 배열 생성: infested (infested[1] = true)
 * 4. 방문할 컴퓨터(=노드)를 표기할 int 1차원 배열 생성: queue (queue.offer(1))
 * 5. 1을 pop(=removeFirst)한 뒤, 1과 간선이 있는 컴퓨터들을 queue에 offer(=addLast)
 * 6. offer하는 동시에 infested[i] = true 처리
 * 7. i = queue.pop() 일 경우, i와 간선이 있는 컴퓨터(j)들을 queue에 offer, 단 infested[j] = true인 경우는 제외한다.
 * 8. 동시에 infested[j] = true 처리
 * 9. queue가 empty될 때까지 반복한다.
 * 10. infested 배열의 true 갯수가 정답
 */
public class _2606_Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int comNum = 0, lineNum = 0, lineFreq = 0;
        boolean[][] graph = null;
        while ((str = br.readLine()) != null) {
            if (comNum == 0) {
                comNum = Integer.parseInt(str);
                graph = new boolean[comNum + 1][comNum + 1];
            } else {
                if (lineNum == 0) {
                    lineNum = Integer.parseInt(str);
                } else {
                    String[] strArr = str.split(" ");
                    int i = Integer.parseInt(strArr[0]);
                    int j = Integer.parseInt(strArr[1]);
                    graph[i][j] = true;
                    graph[j][i] = true;
                    lineFreq++;
                }
                if (lineFreq == lineNum) {
                    break;
                }
            }
        }
        boolean[] infested = new boolean[comNum + 1];
        infested[1] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(1);
        while(!queue.isEmpty()){
            int node = queue.pop();
            for (int i = 2; i < graph.length; i++) {
                if(i != node && graph[node][i] && !infested[i]){
                    queue.offer(i);
                    infested[i] = true;
                }
            }
        }
        int num = 0;
        for (int i = 2; i < infested.length; i++) {
            if(infested[i]){
                num++;
            }
        }
        bw.write(String.valueOf(num));
//        // graph가 제대로 만들어졌는지 체크
//        for (int i = 1; i < graph.length; i++) {
//            for (int j = 1; j < graph.length; j++) {
//                bw.write(String.valueOf(graph[i][j]) + " ");
//            }
//            bw.newLine();
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
