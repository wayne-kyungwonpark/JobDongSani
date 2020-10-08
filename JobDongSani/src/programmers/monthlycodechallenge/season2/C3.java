package programmers.monthlycodechallenge.season2;

import java.util.*;

// 트리의 아무 노드를 루트로 삼아 가장 먼 leaf 노드들을 찾는다.
// 가장 먼 leaf 노드를 기준으로 dijkstra를 돌려 두 번째로 큰 거리 중 큰 값을 리턴한다.
public class C3 {
    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = {{1,5},{2,5},{3,5},{4,5}};
//        int n = 4;
//        int[][] edges = {{1,2},{2,3},{3,4}};
        int n = 3;
        int[][] edges = {{1,3},{2,3}};
        System.out.println(solution(n, edges));
    }

    public static int solution(int n, int[][] edges) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        Map<Integer, ArrayList<Integer>> nodesPerLevel = new HashMap<>();
        Queue<Integer> queueForBfs = new LinkedList<>();
        queueForBfs.offer(n / 2);
        boolean[] visit = new boolean[n + 1];
        visit[n / 2] = true;
        int level = 1;
        while(!queueForBfs.isEmpty()){
            nodesPerLevel.put(level, new ArrayList<>());
            int size = queueForBfs.size();
            for (int i = 0; i < size; i++) {
                int node = queueForBfs.poll();
                for(int adjNode : adjList.get(node)){
                    if(!visit[adjNode]){
                        queueForBfs.offer(adjNode);
                        visit[adjNode] = true;
                        nodesPerLevel.get(level).add(adjNode);
                    }
                }
            }
            level++;
        }
//
//        if(nodesPerLevel.get(level - 2).size() >= 2){
//            answer = level - 2;
//        }else if(nodesPerLevel.get(level - 2).size() == 1){
//            answer = level - 3;
//        }

//        nodesPerLevel.get(level - 2).add(1);

        for (int root : nodesPerLevel.get(level - 2)) {
            if(adjList.get(root).size() != 1){
                continue;
            }
            int[] dist = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if(i != root){
                    dist[i] = 987654321;
                }
            }
            PriorityQueue<Pair> queue = new PriorityQueue<>();
            queue.offer(new Pair(root, 0));
            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                if(pair.y == 987654321){
                    break;
                }
                if(dist[pair.x] < pair.y){
                    continue;
                }
                dist[pair.x] = pair.y;
                for(int node : adjList.get(pair.x)){
                    if(dist[node] > dist[pair.x] + 1){
                        dist[node] = dist[pair.x] + 1;
                        queue.offer(new Pair(node, dist[node]));
                    }
                }
            }

            Arrays.sort(dist);
            if(answer == 0 || answer < dist[dist.length - 2]){
                answer = dist[dist.length - 2];
            }
        }

        return answer;
    }

    private static class Pair implements Comparable<Pair>{
        int x, y;
        public Pair(int x, int y){
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
