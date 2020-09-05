package brandi.secondround;

import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] edges = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            if(a < b){
                edges[i][0] = a;
                edges[i][1] = b;
            }else{
                edges[i][0] = b;
                edges[i][1] = a;
            }
        }

        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]){
                    return -1;
                }else if(o1[0] == o2[0]){
                    if(o1[1] < o2[1]){
                        return -1;
                    }else{
                        return 1;
                    }
                }else{
                    return 1;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int M = Integer.parseInt(br.readLine());
        boolean[][] light = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            if(a < b){
                bfs(a, b, light, N, graph);
            }else{
                bfs(b, a, light, N, graph);
            }
            sb.append(safeArea(light, N));
            if(i != M - 1){
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int safeArea(boolean[][] light, int N) {
        int answer = 0;
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if(!visit[i]){
                dfs(i, light, visit, N);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int start, boolean[][] light, boolean[] visit, int N){
        for (int i = 1; i <= N; i++) {
            if(light[start][i] && !visit[i]){
                visit[i] = true;
                dfs(i, light, visit, N);
            }
        }
    }

    private static void bfs(int a, int b, boolean[][] light, int N, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        visit[a] = true;
        queue.offer(a);
        int[] parent = new int[N + 1];
        parent[a] = a;
        boolean find = false;
        while(!queue.isEmpty()){
            if(find){
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if(cur == b){
                    find = true;
                    break;
                }
                for(int connect : graph.get(cur)){
                    if(!visit[connect]){
                        parent[connect] = cur;
                        visit[connect] = true;
                        queue.offer(connect);
                    }
                }
            }
        }

        int node = b;
        while(parent[node] != node){
            light[node][parent[node]] = !light[node][parent[node]];
            light[parent[node]][node] = !light[parent[node]][node];
            node = parent[node];
        }
    }
}
