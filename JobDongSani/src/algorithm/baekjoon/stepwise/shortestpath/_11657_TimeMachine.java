package algorithm.baekjoon.stepwise.shortestpath;

import java.io.*;
import java.util.ArrayList;

public class _11657_TimeMachine {
    private static int N, M;
    private static ArrayList<ArrayList<Pair>> adj;
    private static boolean[][] reachable;
    private static long[] upper;
    private static final long MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        adj = new ArrayList<>();
        reachable = new boolean[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] ABC = br.readLine().split(" ");
            int A = Integer.parseInt(ABC[0]);
            int B = Integer.parseInt(ABC[1]);
            int C = Integer.parseInt(ABC[2]);
            adj.get(A).add(new Pair(B, C));
            reachable[A][B] = true;
        }

        // reachable[u][v]: u, v 연결되어 있는지 여부 (Floyd Algorithm 사용)
        for (int i = 1; i <= N; i++) {
            reachable[i][i] = true;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    reachable[i][j] = reachable[i][j] || (reachable[i][k] && reachable[k][j]);
                }
            }
        }

        upper = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            upper[i] = MAX;
        }
        upper[1] = 0;

        // Bellman-Ford 수행
        bellmanFord();

        // 음수 사이클 조사
        boolean possible = true;
        for (int here = 1; here <= N; here++) {
            for (int i = 0; i < adj.get(here).size(); i++) {
                int there = adj.get(here).get(i).key;
                int cost = adj.get(here).get(i).value;
                if(reachable[1][here] && upper[here] + cost < upper[there]){
                    possible = false;
                    break;
                }
            }
        }

        if(!possible){
            sb.append(-1);
        }else{
            for (int target = 2; target <= N; target++) {
                if(reachable[1][target] && upper[target] != MAX){
                    sb.append(upper[target]).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bellmanFord(){
        for (int iter = 0; iter < N - 1; iter++) { // iteration을 정점 갯수 - 1만큼 돌린다.
            for (int here = 1; here <= N; here++) {
                for (int i = 0; i < adj.get(here).size(); i++) {
                    int there = adj.get(here).get(i).key;
                    int cost = adj.get(here).get(i).value;
                    if(upper[here] == MAX){
                        continue;
                    }
                    if(upper[here] + (long) cost < upper[there]){
                        upper[there] = upper[here] + cost;
                    }
                }
            }
        }
    }


    private static class Pair{
        int key;
        int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
