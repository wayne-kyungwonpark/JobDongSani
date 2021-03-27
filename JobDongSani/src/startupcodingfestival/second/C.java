package startupcodingfestival.second;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class C {
    private static boolean[] isRoot = null;
    private static int N, Q;
    private static int root;
    private static int[][] parent;
    private static int[] depths;
    private static boolean[] check;
    private static List<ArrayList<Integer>> adjList = new ArrayList<>();
    private static int log = 22; // N <= 500000

    // LCA
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NQ = br.readLine().split(" ");
        N = Integer.parseInt(NQ[0]);
        Q = Integer.parseInt(NQ[1]);
        isRoot = new boolean[N + 1];
//        log = (int) (Math.log(N + 1) / Math.log(2)) + 1;
        parent = new int[N + 1][log];
        depths = new int[N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            isRoot[i] = true;
        }
        for (int i = 0; i < N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] strArr = br.readLine().split(" ");
            isRoot[Integer.parseInt(strArr[1])] = false;
            adjList.get(Integer.parseInt(strArr[0])).add(Integer.parseInt(strArr[1]));
        }

        for (int i = 1; i < N + 1; i++) {
            if(isRoot[i]){
                root = i;
                break;
            }
        }

        dfs(root, 0);
        for (int i = 1; i < log; i++) {
            for (int j = 1; j < N + 1; j++) {
                if(parent[j][i - 1] != 0){
                    parent[j][i] = parent[parent[j][i - 1]][i - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            String[] strArr = br.readLine().split(" ");
            int up = Integer.parseInt(strArr[0]);
            int down = Integer.parseInt(strArr[1]);
            if(LCA(up, down) == up){
                sb.append("yes");
            }else{
                sb.append("no");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int LCA(int x, int y){
        int tmpX = x;
        int tmpY = y;
        if(depths[x] > depths[y]){ // tmpY가 tmpX보다 더 깊은 위치에 오도록 설정
            tmpX = y;
            tmpY = x;
        }
        for (int i = log - 1; i >= 0; i--) {
            if(depths[tmpY] - depths[tmpX] >= (1 << i)){ // 높이 맞춤
                tmpY = parent[tmpY][i];
            }
        }

        if(tmpX == tmpY){
            return tmpX;
        }

        for (int i = log - 1; i >= 0; i--) {
            if(parent[tmpX][i] != 0 && parent[tmpX][i] != parent[tmpY][i]){
                tmpX = parent[tmpX][i];
                tmpY = parent[tmpY][i];
            }
        }

        return parent[tmpX][0];
    }

    private static void dfs(int x, int depth){
        check[x] = true;
        depths[x] = depth;
        for (int i = 0; i < adjList.get(x).size(); i++) {
            int y = adjList.get(x).get(i);
            if(check[y]){
                continue;
            }
            parent[y][0] = x;
            dfs(y, depth + 1);
        }
    }
}
