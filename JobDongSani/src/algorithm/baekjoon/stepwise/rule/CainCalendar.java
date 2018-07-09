package algorithm.baekjoon.stepwise.rule;

import java.util.Scanner;

public class CainCalendar {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		int[] years = new int[testNum];
		for(int i=0;i<testNum;i++) {
			String[] nums = scn.nextLine().split(" ");
			int m = Integer.parseInt(nums[0]);
			int n = Integer.parseInt(nums[1]);
			int x = Integer.parseInt(nums[2]);
			int y = Integer.parseInt(nums[3]);
			int year = 0;
			if(m == 1)
				year = y;
			else if(n ==1)
				year = x;
			else {
				if(m > n) {
					for(int j=0;j<n;j++) {
						int total = m * j + x;
						int check = total % n;
						if(check == y || (y == n && check == 0)) {
							year = total;
							break;
						}
					}
				}else {
					for(int j=0;j<m;j++) {
						int total = n * j + y;
						int check = total % m;
						if(check == x || (x == m && check == 0)) {
							year = total;
							break;
						}
					}
				}
			}
			years[i] = year;
		}
		for(int i=0;i<testNum;i++) {
			if(years[i] != 0)
				System.out.println(years[i]);
			else
				System.out.println("-1");
		}
	}
}
