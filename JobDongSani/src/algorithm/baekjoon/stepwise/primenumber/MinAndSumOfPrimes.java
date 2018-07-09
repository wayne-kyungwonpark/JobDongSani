package algorithm.baekjoon.stepwise.primenumber;

import java.util.Scanner;

public class MinAndSumOfPrimes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1 = Integer.parseInt(scn.nextLine());
		int num2 = Integer.parseInt(scn.nextLine());
		int sum = 0;
		int min = 0;
		boolean minExist = false;
		for(int i=num1;i<=num2;i++) {
			if(i != 1) {
				boolean isPrime = true;
				for(int j=2;j<(int)Math.sqrt(i)+1;j++) {
					if(i % j == 0 && i != j) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) {
					sum += i;
					if(!minExist) {
						min = i;
						minExist = true;
					}
				}
			}
		}
		if(min != 0) {
			System.out.println(sum);
			System.out.println(min);			
		}else
			System.out.println("-1");
	}
}
