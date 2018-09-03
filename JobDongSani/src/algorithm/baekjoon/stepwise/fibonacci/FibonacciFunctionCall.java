package algorithm.baekjoon.stepwise.fibonacci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FibonacciFunctionCall {

	private static String findFunctionCallDynamically(int num) {
		int[] nums = new int[2];
		nums[0] = 1;
		nums[1] = 0;
		if(num == 0) {
			return String.valueOf(nums[0]) + " " + String.valueOf(nums[1]);
		}else {
			for(int i=1;i<=num;i++) {
				int tmp = nums[0] + nums[1];
				nums[0] = nums[1];
				nums[1] = tmp;
			}
			return String.valueOf(nums[0]) + " " + String.valueOf(nums[1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int testFreq = 0;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				bw.write(findFunctionCallDynamically(Integer.parseInt(str)));
				bw.newLine();
				testFreq++;
			}
			if(testNum == testFreq) {
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
