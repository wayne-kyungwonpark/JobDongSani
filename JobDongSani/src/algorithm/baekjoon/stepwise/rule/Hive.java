package algorithm.baekjoon.stepwise.rule;

import java.util.Scanner;

public class Hive {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int count = 1;
		int tmp = 1;
		while(tmp < num) {
			tmp += 6 * count;
			count++;
		}
		System.out.println(count);
	}
}