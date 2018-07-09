package algorithm.baekjoon.stepwise.primenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindPrimeNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		String[] strArr = scn.nextLine().split(" ");
		int[] nums = new int[testNum];
		for(int i=0;i<testNum;i++)
			nums[i] = Integer.parseInt(strArr[i]);
		Arrays.sort(nums);
		List<Integer> primes = new ArrayList<Integer>();
		for(int i=2;i<=nums[testNum-1];i++) {
			boolean isPrime = true;
			for(int j=2;j<=(int)Math.sqrt(i)+1;j++) {
				if(i % j == 0 && i != j) {
					isPrime = false;
					break;
				}
			}
			if(isPrime)
				primes.add(i);
		}
		int count = 0;
		for(int i=0;i<testNum;i++) {
			if(primes.contains(nums[i]))
				count++;
		}
		System.out.println(count);
	}
}
