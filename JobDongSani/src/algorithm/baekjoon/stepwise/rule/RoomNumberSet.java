package algorithm.baekjoon.stepwise.rule;

import java.util.Scanner;

public class RoomNumberSet {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[] chNum = scn.nextLine().toCharArray();
		int[] count = new int[10];
		for(int i=0;i<10;i++)
			count[i] = 0;
		for(int i=0;i<chNum.length;i++) {
			count[Integer.parseInt(Character.toString(chNum[i]))]++;
		}
		count[6] += count[9];
		if(count[6] % 2 == 0)
			count[6] /= 2;
		else
			count[6] = count[6] / 2 + 1;
		count[9] = 0;
		int maxCount = 0;
		for(int i=0;i<10;i++) {
			if(count[i] > maxCount)
				maxCount = count[i];
		}
		System.out.println(maxCount);
	}
}
