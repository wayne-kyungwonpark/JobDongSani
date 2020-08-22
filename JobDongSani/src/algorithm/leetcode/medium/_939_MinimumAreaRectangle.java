package algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _939_MinimumAreaRectangle {
    public static void main(String[] args) {
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(minAreaRect(points));
    }

    public static int minAreaRect(int[][] points) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> xMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if(!xMap.containsKey(points[i][0])){
                xMap.put(points[i][0], new HashSet<>());
            }
            xMap.get(points[i][0]).add(points[i][1]);
        }

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1]){
                    continue;
                }
                if(xMap.get(points[i][0]).contains(points[j][1]) && xMap.get(points[j][0]).contains(points[i][1])){
                    answer = Math.min(answer, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                }
            }
        }
        if(answer == Integer.MAX_VALUE){
            return 0;
        }
        return answer;
    }
}
