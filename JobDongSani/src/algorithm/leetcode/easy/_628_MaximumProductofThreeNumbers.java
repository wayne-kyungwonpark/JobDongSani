package algorithm.leetcode.easy;

import java.util.Arrays;

public class _628_MaximumProductofThreeNumbers {
    public static void main(String[] args) {

    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int result = Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
                nums[0] * nums[1] * nums[nums.length - 1]);

        return result;
    }
}
