package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class ExamResult {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		String grade = null;
		if(num >= 90)
			grade = "A";
		else if(num >= 80)
			grade = "B";
		else if(num >= 70)
			grade = "C";
		else if(num >= 60)
			grade = "D";
		else
			grade = "F";
		System.out.println(grade);
	}
}
