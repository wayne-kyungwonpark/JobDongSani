package algorithm.baekjoon.stepwise.fibonacci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FibonacciNumber1 {
	
	private static int findDynamic(int num) {
		if(num == 0) {
			return 0;
		}else if(num == 1) {
			return 1;
		}else {
			int[] nums = new int[num + 1];
			nums[0] = 0;
			nums[1] = 1;
			for(int i=2;i<=num;i++) {
				nums[i] = nums[i - 1] + nums[i - 2];
			}
			return nums[num];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int num = 0;
		while((str = br.readLine()) != null) {
			num = Integer.parseInt(str);
			bw.write(String.valueOf(findDynamic(num)));
			break;
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
