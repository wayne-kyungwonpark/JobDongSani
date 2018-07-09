package algorithm.baekjoon.stepwise.sort;

import java.util.Scanner;

public class MergeSort {
	
	private static void mergeSort(int[] nums, int start, int end, int[] sortedNums) {
		int middle;
		if(start < end) {
			middle = (start + end) / 2;
			mergeSort(nums, start, middle, sortedNums);
			mergeSort(nums, middle + 1, end, sortedNums);
			merge(nums, start, middle, end, sortedNums);
		}else
			sortedNums[start] = nums[start];
	}
	
	private static void merge(int[] nums, int start, int middle, int end, int[] sortedNums) {
		int index1 = start;
		int index2 = middle + 1;
		int sortIndex = start;
		while(index1 <= middle && index2 <= end) {
			if(nums[index1] <= nums[index2])
				sortedNums[sortIndex] = nums[index1++];
			else
				sortedNums[sortIndex] = nums[index2++];
			sortIndex++;
		}
		if(index1 > middle) {
			while(index2 <= end) {
				sortedNums[sortIndex] = nums[index2++];
				sortIndex++;
			}
		}else {
			while(index1 <= middle) {
				sortedNums[sortIndex] = nums[index1++];
				sortIndex++;
			}
		}
		for(int i=start;i<=end;i++)
			nums[i] = sortedNums[i];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		int[] givenNums = new int[testNum];
		int[] sortedNums = new int[testNum];
		for(int i=0;i<testNum;i++)
			givenNums[i] = Integer.parseInt(scn.nextLine());
		mergeSort(givenNums, 0, testNum - 1, sortedNums);
		for(int i=0;i<testNum;i++)
			System.out.println(sortedNums[i]);
	}
}
