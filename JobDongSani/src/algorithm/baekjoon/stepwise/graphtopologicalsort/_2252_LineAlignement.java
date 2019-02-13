package algorithm.baekjoon.stepwise.graphtopologicalsort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphtopologicalsort/_2252_LineAlignement.java
 *
 * ## 위상정렬
 * 1. 인접리스트 ArrayList<ArrayList<Integer>> : graph
 * 2. 진입차수를 표기할 1차원 int 배열: order[n + 1] (1 ~ n사용)
 * 3. 뒤에 서는 학생의 order를 증가시킨다. 만약 1 3 이 들어온다면, order[3]++
 * 4. 탐색 queue: searchQueue
 * 5. 결과 queue: resultQueue
 * 6. 아래와 같은 과정을 반복한다.
 * 	1. order 값이 0인 노드를 searchQueue에 offer한다.
 * 	2. searchQueue에서 노드 하나를 pop하고 resultQueue에 offer한다.
 * 	3. 해당 노드에 연결된 노드의 order를 감소시킨다.
 * 	4. searchQueue가 빌 때까지 반복한다.
 */
public class _2252_LineAlignement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, m = 0, mFreq = 0;
        int[] order = null;
        ArrayList<ArrayList<Integer>> graph = null;
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            if(m == 0){
                n = Integer.parseInt(strArr[0]);
                m = Integer.parseInt(strArr[1]);
                order = new int[n + 1];
                graph = new ArrayList<>(n + 1);
                for (int i = 0; i <= n; i++) {
                    graph.add(new ArrayList<>());
                }
            }else{
                int a = Integer.parseInt(strArr[0]);
                int b = Integer.parseInt(strArr[1]);
                graph.get(a).add(b);
                order[b]++;
                mFreq++;
                if(m == mFreq){
                    break;
                }
            }
        }

        LinkedList<Integer> searchQueue = new LinkedList<>();
        LinkedList<Integer> resultQueue = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if(order[i] == 0){
                searchQueue.offer(i);
                check[i] = true;
            }
        }

        if(!searchQueue.isEmpty()){
            while(!searchQueue.isEmpty()){
                int node = searchQueue.pop();
                resultQueue.offer(node);
                for (int i : graph.get(node)) {
                    order[i]--;
                }
                // searchQueue에 원소를 넣는 작업을 최소화한다.
                if(searchQueue.isEmpty()){
                    for (int i = 1; i <= n; i++) {
                        if(!check[i] && order[i] == 0){
                            searchQueue.offer(i);
                            check[i] = true;
                        }
                    }
                }
            }
        }else{
            // 이 경우는 나오면 안 됨 (DAG가 아니라는 의미..)
        }

        StringBuilder sb = new StringBuilder();
        for (int i : resultQueue) {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());

//        // graph와 order가 제대로 기입되었는지 확인
//        for (int i = 1; i <= n; i++) {
//            bw.write("order: " + String.valueOf(order[i]) + " & graph " + String.valueOf(i) + ": ");
//            for (int j : graph.get(i)) {
//                bw.write(String.valueOf(j) + " ");
//            }
//            bw.newLine();
//        }

        bw.flush();
        bw.close();
        br.close();
    }
}
