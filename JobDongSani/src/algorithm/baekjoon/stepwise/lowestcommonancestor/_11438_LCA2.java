package algorithm.baekjoon.stepwise.lowestcommonancestor;

import java.io.*;
import java.util.ArrayList;

public class _11438_LCA2 {
    private static int N, M;
    private static ArrayList<ArrayList<Integer>> adjList;
    private static int maxLevel;
    private static int[] depths;
    private static int[][] ancestors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();
        maxLevel = 20;
        depths = new int[N + 1];
        ancestors = new int[N + 1][maxLevel + 1];
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String[] strArr = br.readLine().split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        dfs(1, 0);

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);
            sb.append(lca(node1, node2)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    private static void dfs(int node, int parent){
        depths[node] = depths[parent] + 1;
        ancestors[node][0] = parent;
        // node의 2^i 번째 조상은 node의 2^(i-1) 번째 조상의 2^(i-1) 번째 조상과 같음
        for (int i = 1; i <= maxLevel; i++) {
            ancestors[node][i] = ancestors[ancestors[node][i - 1]][i - 1];
        }
        for(int child : adjList.get(node)){
            if(child != parent){
                dfs(child, node);
            }
        }
    }

    private static int lca(int node1, int node2){
        if(depths[node1] != depths[node2]){
            // node1의 depth를 node2보다 깊게 만든다.
            if(depths[node1] < depths[node2]){
                int tmp = node1;
                node1 = node2;
                node2 = tmp;
            }
            // node1의 depth를 node2와 맞춘다.
            for(int i = maxLevel; i >= 0; i--){
                if(depths[ancestors[node1][i]] >= depths[node2]){
                    node1 = ancestors[node1][i];
                }
            }
        }

//        int lca = node1;
        // 두 노드의 depth가 같으므로 공통 조상을 찾는다.
        if(node1 != node2){
            for (int i = maxLevel; i >= 0; i--) {
                if(ancestors[node1][i] != ancestors[node2][i]){
                    node1 = ancestors[node1][i];
                    node2 = ancestors[node2][i];
                }
//                lca = ancestors[node1][i];
            }
        }else{
            return node1;
        }

        return ancestors[node1][0];
    }
}
