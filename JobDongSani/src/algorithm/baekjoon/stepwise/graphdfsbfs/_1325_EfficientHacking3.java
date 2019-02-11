package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_1325_EfficientHacking3.java
 *
 * ##비대칭 인접리스트 & DFS
 * 1. 신뢰관계를 표기할 인접리스트 ArrayList<ArrayList<Integer>> : confidence
 * 2. i를 해킹하면 j, k, l도 해킹 가능: confidence.get(i) = ArrayList<Integer> {j, k, l, …}
 * 3. confidence의 첫 번째 노드부터 dfs를 통해 해킹가능한 컴퓨터 수를 세어나간다.(max체크)
 * 4. 해킹가능한 컴퓨터 수를 저장할 1차원 int 배열: possibleNum
 * 5. possibleNum 의 원소 중 max 와 같은 것만을 오름차순으로 출력한다.
 */
public class _1325_EfficientHacking3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, m = 0, mFreq = 0;
        ArrayList<ArrayList<Integer>> confidence = null;
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
                possibleNum = new int[n + 1];
            }else{
                confidence.get(Integer.parseInt(strArr[1])).add(Integer.parseInt(strArr[0]));
                mFreq++;
                if(m == mFreq){
                    break;
                }
            }
        }

        int maxNodeNum = 0;
        for (int i = 1; i < n + 1; i++) {
            int nodeNum = 0;
            if(!confidence.get(i).isEmpty()){
                LinkedList<Integer> queue = new LinkedList<>();
                queue.push(i);
                boolean[] check = new boolean[n + 1];
                check[i] = true;
                while(!queue.isEmpty()){
                    int node = queue.pop();
                    if(!confidence.get(node).isEmpty()){
                        for (int j = 0; j < confidence.get(node).size(); j++) {
                            if(!check[confidence.get(node).get(j)]){
                                queue.push(confidence.get(node).get(j));
                                check[confidence.get(node).get(j)] = true;
                                nodeNum++;
                            }
                        }
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
//            if(!confidence.get(i).isEmpty()){
//                for (int j = 0; j < confidence.get(i).size(); j++) {
//                    bw.write(String.valueOf(confidence.get(i).get(j)) + " ");
//                }
//            }
//            bw.newLine();
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
