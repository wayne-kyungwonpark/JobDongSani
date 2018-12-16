package algorithm.baekjoon.stepwise.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class StackSeq {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int testFreq = 0;
		int[] nums = null;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
				nums = new int[testNum];
			}else {
				nums[testFreq++] = Integer.parseInt(str);
			}
			if(testNum == testFreq) {
				break;
			}
		}
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder("");
		int start = 1;
		boolean isPossible = true;
		for(int i=0;i<nums.length;i++) {
			while(start <= nums[i]) {
				stack.push(start++);
				sb.append("+\n");
			}
			if(!stack.isEmpty() && stack.peek().intValue() == nums[i]) {
				stack.pop();
				sb.append("-\n");
			}else {
				isPossible = false;
				break;
			}
		}
		
		if(isPossible && stack.isEmpty()) {
			bw.write(sb.toString());
		}else {
			bw.write("NO");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
