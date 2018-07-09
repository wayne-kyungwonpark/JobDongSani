package algorithm.baekjoon.stepwise.operations;

import java.util.Scanner;

public class SugarDelivery {

	private static final int FIVE_KILO = 5;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int amount = scn.nextInt();
		int remainder = amount % FIVE_KILO;
		int numForFive = 0;
		int numForThree = 0;
		int totalNum = 0;
		switch(remainder) {
			case 0: numForFive = amount / FIVE_KILO; totalNum = numForFive + numForThree;
				break;
			case 1: if(amount / FIVE_KILO >= 1) {numForFive = amount / FIVE_KILO - 1; numForThree = 2; totalNum = numForFive + numForThree;}else {totalNum = -1;}
				break;
			case 2: if(amount / FIVE_KILO >= 2) {numForFive = amount / FIVE_KILO - 2; numForThree = 4; totalNum = numForFive + numForThree;}else {totalNum = -1;}
				break;
			case 3: numForFive = amount / FIVE_KILO; numForThree = 1; totalNum = numForFive + numForThree;
				break;
			case 4: if(amount / FIVE_KILO >= 1) {numForFive = amount / FIVE_KILO - 1; numForThree = 3; totalNum = numForFive + numForThree;}else {totalNum = -1;}
				break;
		}
		System.out.println(totalNum);
	}
}
