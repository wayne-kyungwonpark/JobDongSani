package algorithm.baekjoon.stepwise.sort;

import java.util.Scanner;

public class NumberSort {

	private static int[] minSort(int[] nums) {
		int minIndex = 0;
		for(int i=1;i<nums.length;i++) {
			if(nums[minIndex] > nums[i])
				minIndex = i;
		}
		int[] sortedNums = new int[nums.length];
		sortedNums[0] = nums[minIndex];
		if(nums.length != 1) {
			int[] inputNums = new int[nums.length - 1];
			if(minIndex == 0)
				System.arraycopy(nums, 1, inputNums, 0, nums.length - 1);
			else if(minIndex == nums.length - 1)
				System.arraycopy(nums, 0, inputNums, 0, nums.length - 1);
			else {
				System.arraycopy(nums, 0, inputNums, 0, minIndex);
				System.arraycopy(nums, minIndex + 1, inputNums, minIndex, nums.length - 1 - minIndex);
			}
			System.arraycopy(minSort(inputNums), 0, sortedNums, 1, nums.length - 1);			
		}
		return sortedNums;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		int[] givenNums = new int[testNum];
		for(int i=0;i<testNum;i++)
			givenNums[i] = Integer.parseInt(scn.nextLine());
		int[] sortedNums = new int[testNum];
		sortedNums = minSort(givenNums);
		for(int i=0;i<testNum;i++)
			System.out.println(sortedNums[i]);
	}
}
