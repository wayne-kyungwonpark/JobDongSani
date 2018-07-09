package algorithm.baekjoon.stepwise.gcdlcm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lcm {

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
	
	public static int findLcm(int a, int b) {
		return a * b / findGcd(a, b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int freq = 0;
		while((str = br.readLine()) != null) {
			if(freq == 0)
				testNum = Integer.parseInt(str);
			else {
				String[] nums = str.split(" ");
				int a = Integer.parseInt(nums[0]);
				int b = Integer.parseInt(nums[1]);
				bw.write(String.valueOf(findLcm(a, b)));
				bw.newLine();
			}
			if(freq == testNum)
				break;
			freq++;
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
