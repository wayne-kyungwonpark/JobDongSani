package startupcodingfestival.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class B {
    private static int N = 0;
    private static int[] roots = null;
    private static int[] ranks = null;

    public static void main(String[] args) throws IOException {
        // MST
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Map<String, Integer> cityToInt = new HashMap<>();

        PriorityQueue<Vector> infos = new PriorityQueue<>();
        int cityNum = 0;
        for (int i = 0; i < N; i++) {
            String[] edge = br.readLine().split(" ");
            if(!cityToInt.containsKey(edge[0])){
                cityToInt.put(edge[0], cityNum++);
            }
            if(!cityToInt.containsKey(edge[1])){
                cityToInt.put(edge[1], cityNum++);
            }
            infos.offer(new Vector(edge[0], edge[1], Integer.parseInt(edge[2])));
        }

        roots = new int[cityNum];
        ranks = new int[cityNum];
        for (int i = 0; i < cityNum; i++) {
            roots[i] = i;
            ranks[i] = 0;
        }

        long sum = 0;
        while(!infos.isEmpty()){
            Vector info = infos.poll();
            if(find(cityToInt.get(info.str1)) != find(cityToInt.get(info.str2))){
                union(cityToInt.get(info.str1), cityToInt.get(info.str2));
                sum += info.resouce;
            }
        }

        System.out.println(sum);
    }

    private static int find(int x){
        if(roots[x] == x){
            return x;
        }
        return roots[x] = find(roots[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return;
        }

        if(ranks[x] < ranks[y]){
            roots[x] = y;
        }else{
            roots[y] = x;

            if(ranks[x] == ranks[y]){
                ranks[x]++;
            }
        }
    }

    private static class Vector implements Comparable<Vector> {
        String str1;
        String str2;
        int resouce;

        public Vector(String str1, String str2, int resouce) {
            this.str1 = str1;
            this.str2 = str2;
            this.resouce = resouce;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vector vector = (Vector) o;
            return (Objects.equals(str1, vector.str1) &&
                    Objects.equals(str2, vector.str2)) ||
                    (Objects.equals(str1, vector.str2) &&
                    Objects.equals(str2, vector.str1));
        }

        @Override
        public int hashCode() {
            return Objects.hash(str1, str2) + Objects.hash(str2, str1);
        }

        @Override
        public int compareTo(Vector o) {
            if(this.resouce < o.resouce){
                return -1;
            }else if(this.resouce > o.resouce){
                return 1;
            }
            return 0;
        }
    }
}
