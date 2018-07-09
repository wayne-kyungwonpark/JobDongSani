package algorithm.baekjoon.stepwise.gcdlcm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Questioning {
	
	public static int findMultiGcd(int[] nums) {
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
		int min = 0;
		int[] nums = null;
		while((str = br.readLine()) != null) {
			if(freq == 0) {
				testNum = Integer.parseInt(str);
				nums = new int[testNum];
			}else {
				int tmp = Integer.parseInt(str);
				if(freq == 1)
					min = tmp;
				if(min > tmp)
					min = tmp;
				nums[freq - 1] = tmp;
			}
			if(freq == testNum)
				break;
			freq++;
		}
		Set<Integer> gcdSet = new HashSet<Integer>();
		for(int i=0;i<min;i++) {
			int gcd = findMultiGcd(nums);
			if(gcd != 1)
				gcdSet.add(gcd);
			for(int j=0;j<testNum;j++)
				nums[j] += 1;
		}
		List<Integer> gcdList = new ArrayList<Integer>(gcdSet);
		Collections.sort(gcdList);
		for(Integer i : gcdList)
			bw.write(String.valueOf(i) + " ");
		bw.flush();
		br.close();
		bw.close();
	}
}
