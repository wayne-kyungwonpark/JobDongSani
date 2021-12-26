package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _11_ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        // 왼쪽에서부터 height를 보았을 때 내림차순으로 내려가는 가장 왼쪽 x 좌표 모음
        List<Integer> left = new ArrayList<>();
        // 오른쪽에서부터 height를 보았을 때 내림차순으로 내려가는 가장 오른쪽 x 좌표 모음
        List<Integer> right = new ArrayList<>();

        left.add(0);
        for (int i = 1; i < height.length; i++) {
            if(height[i] > height[left.get(left.size() - 1)]){
                left.add(i);
            }
        }

        right.add(height.length - 1);
        for (int i = height.length - 2; i >= 0; i--) {
            if(height[i] > height[right.get(right.size() - 1)]){
                right.add(i);
            }
        }

        int result = 0;
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                int minHeight = Math.min(height[left.get(i)], height[right.get(j)]);
                int area = minHeight * Math.abs(left.get(i) - right.get(j));
                if(area > result){
                    result = area;
                }
            }
        }

        return result;
    }
}
