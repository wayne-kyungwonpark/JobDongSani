package algorithm.baekjoon.stepwise.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingSort {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		int[] givenNums = new int[testNum];
		int maxNum = 0;
		Map<Integer, Integer> countingMap = new HashMap<Integer, Integer>();
		for(int i=0;i<testNum;i++) {
			givenNums[i] = Integer.parseInt(scn.nextLine());
			if(maxNum < givenNums[i])
				maxNum = givenNums[i];
			if(countingMap.containsKey(givenNums[i])) {
				int count = countingMap.get(givenNums[i]);
				countingMap.remove(givenNums[i]);
				countingMap.put(givenNums[i], count + 1);
			}else
				countingMap.put(givenNums[i], 1);
		}
		int[] countingArr = new int[maxNum + 1];
		int countSum = 0;
		for(int i=0;i<countingArr.length;i++) {
			if(countingMap.containsKey(i))
				countSum += countingMap.get(i);
			countingArr[i] = countSum;
		}
		int[] sortedArr = new int[testNum];
		for(int i=testNum-1;i>=0;i--) {
			sortedArr[countingArr[givenNums[i]] - 1] = givenNums[i];
			countingArr[givenNums[i]]--;
		}
		for(int i=0;i<testNum;i++)
			System.out.println(sortedArr[i]);
	}
}
