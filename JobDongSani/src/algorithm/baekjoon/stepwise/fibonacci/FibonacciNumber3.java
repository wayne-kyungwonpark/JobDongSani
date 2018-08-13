package algorithm.baekjoon.stepwise.fibonacci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FibonacciNumber3 {
	
	private static long findPisanoPeriod(long num) {
		long mod = num % 1500000;
		if(num == 0) {
			return 0;
		}else if(num == 1) {
			return 1;
		}else {
			long[] nums = new long[2];
			nums[0] = 0;
			nums[1] = 1;
			for(int i=2;i<=mod;i++) {
				long tmp = (nums[0] + nums[1]) % 1000000;
				nums[0] = nums[1];
				nums[1] = tmp;
			}
			return nums[1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		long num = 0;
		while((str = br.readLine()) != null) {
			num = Long.parseLong(str);
			bw.write(String.valueOf(findPisanoPeriod(num)));
			break;
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
