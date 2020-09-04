package brandi.firstround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    private static int[][] graph = null;
    private static final int MAX_VALUE = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        graph = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);
            int time = Integer.parseInt(strArr[2]);
            graph[node1][node2] = time;
        }

        boolean[] visit = new boolean[N + 1];
        boolean[] check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            boolean negCycle = dfs(i, check, visit);

        }

        int[] distance = new int[N + 1];
    }

    private static boolean dfs(int current, boolean check[], boolean[] visit) {
        if(visit[current]){
            return true;
        }
        if(check[current]){
            return false;
        }
        return false;
    }
}
