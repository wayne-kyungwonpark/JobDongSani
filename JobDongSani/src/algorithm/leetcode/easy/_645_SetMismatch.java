package algorithm.leetcode.easy;

public class _645_SetMismatch {
    public static void main(String[] args) {
        int[] result = findErrorNums(new int[]{1, 2, 2, 4});
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] findErrorNums(int[] nums) {
        boolean[] check = new boolean[nums.length + 1];
        int dup = 0;
        for (int i = 0; i < nums.length; i++) {
            if(check[nums[i]]){
                dup = nums[i];
            }else{
                check[nums[i]] = true;
            }
        }

        int[] result = null;
        for (int i = 1; i < check.length; i++) {
            if(!check[i]){
                result = new int[]{dup, i};
                break;
            }
        }

        return result;
    }
}
