package algorithm.leetcode.easy;

public class _283_MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int[] answer = new int[nums.length];
        int front = 0, end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                answer[end--] = 0;
            }else{
                answer[front++] = nums[i];
            }
        }
        for (int i = 0; i < answer.length; i++) {
            nums[i] = answer[i];
        }
    }
}
