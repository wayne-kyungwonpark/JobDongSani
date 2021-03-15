package algorithm.leetcode.medium;

import java.util.LinkedList;

public class _209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
//        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        long sum = 0;

        while(end < nums.length){
            sum += nums[end];
            while(start <= end && sum >= target){
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }


        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
