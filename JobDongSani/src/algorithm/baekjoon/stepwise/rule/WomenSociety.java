package algorithm.baekjoon.stepwise.rule;

import java.util.Scanner;

public class WomenSociety {

	private static int peopleNum(int floor, int number) {
		if(floor == 0)
			return number;
		else {
			int sum = 0;
			int belowFloor = floor - 1;
			for(int i=1;i<=number;i++)
				sum += peopleNum(belowFloor, i);
			return sum;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		int[] peoples = new int[testNum];
		for(int i=0;i<testNum;i++) {
			int floor = Integer.parseInt(scn.nextLine());
			int number = Integer.parseInt(scn.nextLine());
			peoples[i] = peopleNum(floor, number);
		}
		for(int i=0;i<testNum;i++)
			System.out.println(peoples[i]);
	}
}
