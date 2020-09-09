package algorithm.baekjoon.stepwise.shortestpath;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _10282_Hacking {
    private static int n, d, c;
    private static ArrayList<ArrayList<Pair>> adj;
    private static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] ndc = br.readLine().split(" ");
            n = Integer.parseInt(ndc[0]);
            d = Integer.parseInt(ndc[1]);
            c = Integer.parseInt(ndc[2]);
            adj = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                adj.add(new ArrayList<>());
            }

            for (int j = 0; j < d; j++) {
                String[] abs = br.readLine().split(" ");
                int a = Integer.parseInt(abs[0]);
                int b = Integer.parseInt(abs[1]);
                int s = Integer.parseInt(abs[2]);
                adj.get(b).add(new Pair(a, s));
            }
            int[] answer = dijkstra();
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] dijkstra() {
        int[] answer = new int[2];
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = MAX;
        }
        dist[c] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(c, 0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int here = pair.first;
            int cost = pair.second;
            if(dist[here] < cost){
                continue;
            }
            for (int i = 0; i < adj.get(here).size(); i++) {
                int there = adj.get(here).get(i).first;
                int nextDist = cost + adj.get(here).get(i).second;
                if(nextDist < dist[there]){
                    dist[there] = nextDist;
                    queue.offer(new Pair(there, nextDist));
                }
            }
        }

        int cnt = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if(dist[i] != MAX){
                cnt++;
                max = Math.max(dist[i], max);
            }
        }

        answer[0] = cnt;
        answer[1] = max;
        return answer;
    }

    private static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.second < o.second){
                return -1;
            }else if(this.second > o.second){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
