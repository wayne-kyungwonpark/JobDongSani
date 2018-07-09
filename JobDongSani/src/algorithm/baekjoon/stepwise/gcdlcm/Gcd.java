package algorithm.baekjoon.stepwise.gcdlcm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gcd {

	public static String representToOne(long num) {
		StringBuilder sb = new StringBuilder("");
		long freq = 0l;
		while(freq < num) {
			sb.append("1");
			freq++;
		}
		return sb.toString();
	}
	
	public static long findGcd(long a, long b) {
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
		while((str = br.readLine()) != null) {
			String[] nums = str.split(" ");
			long a = Long.parseLong(nums[0]);
			long b = Long.parseLong(nums[1]);
			bw.write(representToOne(findGcd(a, b)));
			break;
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
