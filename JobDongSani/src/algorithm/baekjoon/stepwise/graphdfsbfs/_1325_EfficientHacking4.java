package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.ArrayList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_1325_EfficientHacking4.java
 *
 * ## 비대칭 인접리스트 (생성 방식 반대로) & DFS
 * 1. 신뢰관계를 표기할 인접리스트 ArrayList<ArrayList<Integer>> : confidence
 * 2. i, j 가 input으로 들어올 경우 (j해킹할 시 i도 해킹 가능) ArrayList.get(i).add(j)
 * 3. ArrayList의 1부터 n까지 아래와 같은 과정을 수행한다. (dfs)
 * 4. visited: 방문한 노드를 순서대로 기록하는 1차원 정수 배열
 * 5. 예시에서는 visited[1] = 1 -> 3 -> 4 -> 5 순으로 바뀜
 * 6. nodeValue: 노드별로 방문할 수 있는 컴퓨터 수 (자기자신 제외)
 * 7. nodeValue[1] = 1 -> 2 -> 3 순으로 1씩 증가
 */
public class _1325_EfficientHacking4 {
    private static int[] visited, nodeValue;
    private static int presentNode;
    private static ArrayList<ArrayList<Integer>> confidence;

    private static void dfs(int i){
        visited[i] = presentNode;
//        for (int j = 0; j < confidence.get(i).size(); j++) {
//            if(visited[confidence.get(i).get(j)] != presentNode){
//                nodeValue[confidence.get(i).get(j)]++;
//                dfs(confidence.get(i).get(j));
//            }
//        }
        for(int nodeInList : confidence.get(i)){
            if(visited[nodeInList] != presentNode){
                nodeValue[nodeInList]++;
                dfs(nodeInList);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, m = 0, mFreq = 0;
        int[] possibleNum = null;
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            if(n == 0) {
                n = Integer.parseInt(strArr[0]);
                m = Integer.parseInt(strArr[1]);
                confidence = new ArrayList<ArrayList<Integer>>(n + 1);
                for (int i = 0; i < n + 1; i++) {
                    confidence.add(new ArrayList<>(0));
                }
                visited = new int[n + 1];
                nodeValue = new int[n + 1];
            }else{
                confidence.get(Integer.parseInt(strArr[0])).add(Integer.parseInt(strArr[1]));
                mFreq++;
                if(m == mFreq){
                    break;
                }
            }
        }

        long sT = System.currentTimeMillis();
        for (int i = 1; i < n + 1; i++) {
            presentNode = i;
            dfs(i);
        }

        int maxValue = 0;
        for (int i = 1; i < nodeValue.length; i++) {
            if(maxValue == 0 || nodeValue[i] > maxValue){
                maxValue = nodeValue[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nodeValue.length; i++) {
            if(nodeValue[i] == maxValue){
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.newLine();
        long eT = System.currentTimeMillis();

        System.out.println(eT - sT);

//        // confidence가 제대로 기록되었는지 체크
//        for (int i = 1; i < n + 1; i++) {
//            if(!confidence.get(i).isEmpty()){
//                for (int j = 0; j < confidence.get(i).size(); j++) {
//                    bw.write(String.valueOf(i) + ": " + String.valueOf(confidence.get(i).get(j)) + " ");
//                }
//            }
//            bw.newLine();
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
