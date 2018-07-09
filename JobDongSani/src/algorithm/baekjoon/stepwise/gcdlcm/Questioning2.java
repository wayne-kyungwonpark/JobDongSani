package algorithm.baekjoon.stepwise.gcdlcm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Questioning2 {

	public static int findMultiGcd(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		if(nums.length == 2)
			return findGcd(nums[0], nums[1]);
		else {
			int len = nums.length;
			int[] newNums = new int[len - 1];
			System.arraycopy(nums, 0, newNums, 0, len - 1);
			return findGcd(findMultiGcd(newNums), nums[len - 1]);
		}
	}

	public static int findGcd(int a, int b) {
		if(a == 0)
			return b;
		else if(b == 0)
			return a;
		else {
			if(a > b)
				return findGcd(a % b, b);
			else
				return findGcd(a, b % a);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int freq = 0;
		int[] nums = null;
		while((str = br.readLine()) != null) {
			if(freq == 0) {
				testNum = Integer.parseInt(str);
				nums = new int[testNum];
			}
			else {
				nums[freq - 1] = Integer.parseInt(str);
			}
			if(freq == testNum)
				break;
			freq++;
		}
		Arrays.sort(nums);
		int[] diffs = new int[testNum - 1];
		for(int i=0;i<testNum-1;i++)
			diffs[i] = nums[i + 1] - nums[i];
		
		int gcdOfDiffs = findMultiGcd(diffs);
		
		for(int i=2;i<=gcdOfDiffs;i++) {
			if(gcdOfDiffs % i == 0)
				bw.write(String.valueOf(i) + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
