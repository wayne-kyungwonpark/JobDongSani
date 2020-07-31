package algorithm.baekjoon.stepwise.lowestcommonancestor;

import java.io.*;
import java.util.ArrayList;

public class _3584_TheLowestCommonAncestor {
    private static int N;
    private static ArrayList<ArrayList<Integer>> adjList;
    private static int[] depths;
    private static int maxDepth;
    private static int[][] ancestors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            adjList = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                adjList.add(new ArrayList<>());
            }
            depths = new int[N + 1];
            maxDepth = (int) (Math.log(N + 1) / Math.log(2)) + 1;
            ancestors = new int[N + 1][maxDepth + 1];
            boolean[] isChild = new boolean[N + 1];
            for (int j = 0; j < N - 1; j++) {
                String[] strArr = br.readLine().split(" ");
                int node1 = Integer.parseInt(strArr[0]);
                int node2 = Integer.parseInt(strArr[1]);
                adjList.get(node1).add(node2);
                adjList.get(node2).add(node1);
                isChild[node2] = true;
            }

            int root = 0;
            for (int j = 1; j <= N; j++) {
                if(!isChild[j]){
                    root = j;
                    break;
                }
            }

            dfs(root, 0);

            String[] connect = br.readLine().split(" ");
            int node1 = Integer.parseInt(connect[0]);
            int node2 = Integer.parseInt(connect[1]);

            sb.append(lca(node1, node2)).append("\n");
            N = 0;
            adjList = null;
            depths = null;
            maxDepth = 0;
            ancestors = null;
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
        for (int i = 1; i <= maxDepth; i++) {
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
            for(int i = maxDepth; i >= 0; i--){
                if(depths[ancestors[node1][i]] >= depths[node2]){
                    node1 = ancestors[node1][i];
                }
            }
        }

//        int lca = node1;
        // 두 노드의 depth가 같으므로 공통 조상을 찾는다.
        if(node1 != node2){
            for (int i = maxDepth; i >= 0; i--) {
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
