package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class ExceedAvg {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = scn.nextInt();
		for(int i=0;i<testNum;i++) {
			int stNum = scn.nextInt();
			int[] stScores = new int[stNum];
			int sum = 0;
			int cntExceedAvg = 0;
			for(int j=0;j<stNum;j++) {
				stScores[j] = scn.nextInt();
				sum += stScores[j];
			}
			float avg = (float) sum / stNum;
			for(int j=0;j<stNum;j++) {
				if(stScores[j] > avg)
					cntExceedAvg++;
			}
			System.out.printf("%.3f", (float) cntExceedAvg / stNum * 100);System.out.println("%");
		}
	}
}
