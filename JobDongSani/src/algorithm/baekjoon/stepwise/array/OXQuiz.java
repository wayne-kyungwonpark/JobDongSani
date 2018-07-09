package algorithm.baekjoon.stepwise.array;

import java.util.Scanner;

public class OXQuiz {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testcaseNum = Integer.valueOf(scn.nextLine());
		int[] scoreArr = new int[testcaseNum];
		for(int i=0;i<testcaseNum;i++) {
			String str = scn.nextLine();
			char[] chArr = str.toCharArray();
			int contiCheck =0;
			int score = 0;
			for(int j=0;j<chArr.length;j++) {
				if("O".equals(Character.toString(chArr[j]))) {
					contiCheck++;
					score += contiCheck;
				}else {
					contiCheck = 0;
				}
			}
			scoreArr[i] = score;
		}
		for(int i=0;i<testcaseNum;i++)
			System.out.println(scoreArr[i]);	
	}
}
