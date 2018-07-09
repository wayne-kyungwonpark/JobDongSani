package algorithm.baekjoon.stepwise.array;

import java.util.Scanner;

public class MeanScore {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int totalScore = 0;
		for(int i=0;i<5;i++) {
			int score = Integer.parseInt(scn.nextLine());
			if(score < 40)
				totalScore += 40;
			else
				totalScore += score;
		}
		int meanScore = totalScore / 5;
		System.out.println(meanScore);
	}
}
