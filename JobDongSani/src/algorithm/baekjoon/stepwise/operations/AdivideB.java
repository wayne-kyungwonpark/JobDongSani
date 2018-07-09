package algorithm.baekjoon.stepwise.operations;

import java.util.Scanner;

public class AdivideB {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		double num1 = scn.nextInt();
		double num2 = scn.nextInt();
		if(num2 != 0) {
			double tmp = num1/num2;
			System.out.println(tmp);
		}
	}
}
