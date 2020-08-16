package algorithm.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _1284_MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {
    public static void main(String[] args) {
        int[][] mat = {{0,0},{0,1}};
        System.out.println(minFlips(mat));
    }

    public static int minFlips(int[][] mat) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = mat.length;
        int n = mat[0].length;

        // mat to int
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start ^= (mat[i][j] << (i * n + j));
            }
        }

        // 시작부터 조건을 만족시킬 경우
        if(start == 0){
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        queue.offer(start);
        visit.add(start);

        int steps = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int j = 0; j < m * n; j++) {
                    int next = ((1 << j) ^ current);
                    for (int k = 0; k < directions.length; k++) {
                        int x = directions[k][0] + (j / n);
                        int y = directions[k][1] + (j % n);
                        if(x < 0 || x >= m || y < 0 || y >= n){
                            continue;
                        }
                        next ^= (1 << (x * n + y)); // flip
                    }
                    if(next == 0){
                        return steps;
                    }

                    if(!visit.contains(next)){
                        queue.offer(next);
                        visit.add(next);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
