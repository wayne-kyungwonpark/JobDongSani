package algorithm.baekjoon.stepwise.simulation;

import java.util.Scanner;

public class Tournament {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] strArr = scn.nextLine().split(" ");
		int total = Integer.parseInt(strArr[0]);
		int j = Integer.parseInt(strArr[1]);
		int h = Integer.parseInt(strArr[2]);
		int roundNum = 1;
		boolean doesMeet = false;
		if(total % 2 == 1)
			total++;
		while(total / 2 >= 1) {
			if((j - h == -1 && j % 2 == 1) || (j - h == 1 && j % 2 == 0)){
				System.out.println(roundNum);
				doesMeet = true;
				break;
			}
			if(total % 2 == 0)
				total /= 2;
			else
				total = total / 2 + 1;
			if(j % 2 == 0)
				j /= 2;
			else
				j = j / 2 + 1;
			if(h % 2 == 0)
				h /= 2;
			else
				h = h / 2 + 1;
			roundNum++;
		}
		if(!doesMeet)
			System.out.println("-1");
	}
}
