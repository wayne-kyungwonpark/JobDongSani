package algorithm.leetcode.hard;

public class _41_FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public static int firstMissingPositive(int[] nums) {
        boolean check[] = new boolean[500001];

        for(int num : nums){
            if(num >= 0 && num <= 500000){
                check[num] = true;
            }
        }

        for (int i = 1; i < 500001; i++) {
            if(!check[i]){
                return i;
            }
        }

        return 500001;
    }
}
