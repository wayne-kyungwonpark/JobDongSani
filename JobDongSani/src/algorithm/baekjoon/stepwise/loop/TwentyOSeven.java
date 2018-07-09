package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class TwentyOSeven {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int month = scn.nextInt();
		int day = scn.nextInt();
		int diff = day - 1;
		switch(month) {
			case 1: diff += 0; break;
			case 2: diff += 31; break;
			case 3: diff += 31 + 28; break;
			case 4: diff += 31 + 28 + 31; break;
			case 5: diff += 31 + 28 + 31 + 30; break;
			case 6: diff += 31 + 28 + 31 + 30 + 31; break;
			case 7: diff += 31 + 28 + 31 + 30 + 31 + 30; break;
			case 8: diff += 31 + 28 + 31 + 30 + 31 + 30 + 31; break;
			case 9: diff += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31; break;
			case 10: diff += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30; break;
			case 11: diff += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31; break;
			case 12: diff += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30; break;
		}
		int remainder = diff % 7;
		switch(remainder) {
			case 0: System.out.println("MON"); break;
			case 1: System.out.println("TUE"); break;
			case 2: System.out.println("WED"); break;
			case 3: System.out.println("THU"); break;
			case 4: System.out.println("FRI"); break;
			case 5: System.out.println("SAT"); break;
			case 6: System.out.println("SUN"); break;
		}
	}
}
