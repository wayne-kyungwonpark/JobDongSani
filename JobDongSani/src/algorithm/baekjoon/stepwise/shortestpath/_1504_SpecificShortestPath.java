package algorithm.baekjoon.stepwise.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _1504_SpecificShortestPath {
    private static int N = 0;
    private static int E = 0;
    private static ArrayList<ArrayList<Pair>> adjList = null;
    private static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NE = br.readLine().split(" ");
        N = Integer.parseInt(NE[0]);
        E = Integer.parseInt(NE[1]);
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] strArr = br.readLine().split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);
            int dist = Integer.parseInt(strArr[2]);
            adjList.get(node1).add(new Pair(node2, dist));
            adjList.get(node2).add(new Pair(node1, dist));
        }

        String[] specifics = br.readLine().split(" ");
        int specific1 = Integer.parseInt(specifics[0]);
        int specific2 = Integer.parseInt(specifics[1]);

        // 필요한 것
            // 1 to specific1 최단 경로 계산
            // 1 to specific2 최단 경로 계산
            // N to specific1 (= specific1 to N) 최단 경로 계산
            // N to specific2 (= specific2 to N) 최단 경로 계산
            // specific1 to specific2 (= specific2 to specific1) 최단 경로 계산

        // specific1과 specific2에서의 dijkstra 두 번 돌리면 필요한 모든 값을 알 수 있음
        int[] forSpecific1 = dijkstra(specific1);
        int[] forSpecific2 = dijkstra(specific2);

        if(forSpecific1[1] == MAX || forSpecific1[specific2] == MAX || forSpecific2[N] == MAX
                || forSpecific2[1] == MAX || forSpecific1[N] == MAX){
            System.out.println(-1);
            return;
        }

        // answer = min(1 to specific1 + specific1 to specific2 + specific2 to N, 1 to specific2 + specific2 to specific1 + specific1 to N)
        System.out.println(Math.min(forSpecific1[1] + forSpecific1[specific2] + forSpecific2[N]
                , forSpecific2[1] + forSpecific2[specific1] + forSpecific1[N]));

    }

    private static int[] dijkstra(int start){
        int[] dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            if(i == start){
                dist[i] = 0;
            }else{
                dist[i] = MAX;
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(start, 0));
        queue.offer(new Pair(start, MAX));
        while(!queue.isEmpty()){
            Pair prev = queue.poll();
            if(prev.y == MAX){
                break;
            }
            for (Pair node : adjList.get(prev.x)) {
                int newDist = prev.y + node.y;
                if(newDist < dist[node.x]){
                    dist[node.x] = newDist;
                    queue.offer(new Pair(node.x, newDist));
                }
            }
        }

        return dist;
    }


    private static class Pair implements Comparable<Pair>{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.y < o.y){
                return -1;
            }else if(this.y > o.y){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
