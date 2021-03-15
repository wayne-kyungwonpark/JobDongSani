package algorithm.leetcode.medium;

import java.util.LinkedList;

public class _209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
//        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
//        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int min = 0;

        int start = 0;
        int end = 0;
        long sum = 0;

        while(start < nums.length && end < nums.length){
            if(start <= end){
                sum += nums[end];
                end++;
            }else{
                end = start;
            }

            while(sum >= target){
                int candidate = end - start;
                if(min == 0){
                    min = candidate;
                }else{
                    min = Math.min(min, candidate);
                }
                if(min == 1){
                    break;
                }

                sum -= nums[start];
                start++;
            }

            if(min == 1){
                break;
            }
        }

        return min;
    }
}
