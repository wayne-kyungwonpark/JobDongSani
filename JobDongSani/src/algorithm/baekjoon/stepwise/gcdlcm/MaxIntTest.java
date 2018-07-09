package algorithm.baekjoon.stepwise.gcdlcm;

public class MaxIntTest {

	public static int findMultiGcd(int[] nums) {
		if(nums.length == 2)
			return findGcd(nums[0], nums[1]);
		else {
			int len = nums.length;
			int[] newNums = new int[len - 1];
			System.arraycopy(nums, 0, newNums, 0, len - 1);
			return findGcd(findMultiGcd(newNums), nums[len - 1]);
		}
	}
	
	public static int findGcd(int a, int b) {
		if(a == 0)
			return b;
		else if(b == 0)
			return a;
		else {
			if(a > b)
				return findGcd(a % b, b);
			else
				return findGcd(a, b % a);
		}
	}
	
	public static void main(String[] args) {
//		boolean isOver = 1000000000 > Long.MAX_VALUE;
//		System.out.println(isOver);
//		System.out.println(Long.MAX_VALUE);
		
//		System.out.println(findGcd(111111111, 111111111111l));
		int[] nums = {6, 12, 15, 9, 111, 111111};
		int[] ones = {1, 1, 1, 1, 1, 1};
//		System.out.println(findMultiGcd(nums));
	}
}
