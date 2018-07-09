package algorithm.baekjoon.stepwise.function;

public class SelfNumber {

	private static final int TOTAL = 10000;
	private static int cal(int num) {
		String numStr = Integer.toString(num);
		char[] numCharArr = numStr.toCharArray();
		int tmp = num;
		for(int i=0;i<numCharArr.length;i++)
			tmp += Character.getNumericValue(numCharArr[i]);
		return tmp;
	}
	public static void main(String[] args) {
		int[] nums = new int[TOTAL];
		for(int i=0;i<TOTAL;i++)
			nums[i] = 1;
		for(int i=0;i<TOTAL;i++) {
			if(nums[i] != 0) {
				int tmp = i+1;
				tmp = cal(tmp);
				while(tmp <= TOTAL) {
					nums[tmp - 1] = 0;
					tmp = cal(tmp);
				}
			}
		}
		for(int i=0;i<TOTAL;i++) {
			if(nums[i] == 1)
				System.out.println(i+1);
		}
	}
}