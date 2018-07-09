package algorithm.baekjoon.stepwise.gcdlcm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Rings {

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
		int ringNum = 0;
		String[] nums = null;
		while((str = br.readLine()) != null) {
			if(ringNum == 0)
				ringNum = Integer.parseInt(str);
			else {
				nums = str.split(" ");
				break;
			}
		}
		for(int i=1;i<ringNum;i++) {
			int gcd = findGcd(Integer.parseInt(nums[0]), Integer.parseInt(nums[i]));
			bw.write(String.valueOf(Integer.parseInt(nums[0]) / gcd) + "/" + String.valueOf(Integer.parseInt(nums[i]) / gcd));
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
