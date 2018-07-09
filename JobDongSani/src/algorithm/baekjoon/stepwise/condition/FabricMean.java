package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class FabricMean {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int count = scn.nextInt();
		int[] nums = new int[count];
		int max = 0;
		for(int i=0;i<count;i++) {
			nums[i] = scn.nextInt();
			if(nums[i] > max)
				max = nums[i];
		}
		float sum = 0;
		for(int i=0;i<count;i++)
			sum += (float) nums[i] / max * 100;
		System.out.printf("%.2f", sum / count);
	}
}
