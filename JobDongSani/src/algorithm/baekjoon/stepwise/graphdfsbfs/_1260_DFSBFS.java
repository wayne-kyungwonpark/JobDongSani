package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class _1260_DFSBFS {
    private static int N = 0, M = 0, V = 0;
    private static ArrayList<Integer>[] adjacentList = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int mFreq = 0;
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            if(N == 0){
                N = Integer.parseInt(strArr[0]);
                M = Integer.parseInt(strArr[1]);
                V = Integer.parseInt(strArr[2]);
                adjacentList = new ArrayList[N + 1];
                for (int i = 1; i <= N; i++) {
                    adjacentList[i] = new ArrayList<>();
                }
            }else{
                int first = Integer.parseInt(strArr[0]);
                int second = Integer.parseInt(strArr[1]);
                adjacentList[first].add(second);
                adjacentList[second].add(first);
                mFreq++;
                if(mFreq == M){
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        // DFS
        dfs(sb);
        sb.append("\n");
        // BFS
        bfs(sb);
        System.out.print(sb.toString());
        br.close();
    }

    private static void bfs(StringBuilder sb) {
        boolean[] check = new boolean[N + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(V);
        check[V] = true;
        while(!queue.isEmpty()){
            int start = queue.removeFirst();
            sb.append(start).append(" ");
            int[] nodes = new int[adjacentList[start].size()];
            for (int i = 0; i < adjacentList[start].size(); i++) {
                nodes[i] = adjacentList[start].get(i);
            }
            Arrays.sort(nodes);
            for(int node : nodes){
                if(!check[node]){
                    queue.add(node);
                    check[node] = true;
                }
            }
        }
    }

    // dfs 로 하면 첫 번째 예시에서 문제가 있음..
    // [1] -> (1빠짐)[] -> (4, 3, 2 순대로 추가)[4 3 2] -> (2빠짐, 2에 연결된 1, 4 중 이미 빠져서 제외되는 1 말고 추가해야 할 4가 이미 추가되어 있어서 순서를 지켜야 하는 기능 에러)[4 3] -> (3빠짐)[4] -> (4빠짐)[]
    // 1, 2, 3, 4 순대로 빠짐
    private static void dfs(StringBuilder sb){
        boolean[] check = new boolean[N + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(V);
        check[V] = true;
        while(!queue.isEmpty()){
            int start = queue.removeLast();
            sb.append(start).append(" ");
            int[] nodes = new int[adjacentList[start].size()];
            for (int i = 0; i < adjacentList[start].size(); i++) {
                nodes[i] = adjacentList[start].get(i);
            }
            Arrays.sort(nodes);
            for(int i = nodes.length - 1; i >= 0; i--){
                if(!check[nodes[i]]){
                    queue.add(nodes[i]);
                    check[nodes[i]] = true;
                }
            }
        }
    }
}
