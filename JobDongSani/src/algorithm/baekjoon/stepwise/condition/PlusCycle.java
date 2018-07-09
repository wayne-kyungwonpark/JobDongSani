package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class PlusCycle {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int tmp = -1;
		int count = 0;
		while(num != tmp) {
			if(count == 0)
				tmp = num;
			int sepaNum = tmp % 10;
			int sepaSum = ((tmp / 10) + (tmp % 10)) % 10;
			tmp = sepaNum * 10 + sepaSum;
			count++;
		}
		System.out.println(count);
	}
}
