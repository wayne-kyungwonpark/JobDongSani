package algorithm.baekjoon.stepwise.math;

import java.util.Scanner;

public class PerfectSquareNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1 = Integer.parseInt(scn.nextLine());
		int num2 = Integer.parseInt(scn.nextLine());
		int start = (int) Math.sqrt(num1);
		int end = (int) Math.sqrt(num2);
		if(num1 != start * start)
			start++;
		if(start > end)
			System.out.println("-1");
		else {
			int sum = 0;
			for(int i=start;i<=end;i++)
				sum += i * i;
			System.out.println(sum);
			System.out.println(start * start);
		}
	}
}
