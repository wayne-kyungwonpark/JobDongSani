package algorithm.baekjoon.stepwise.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ParenthesisValue2 {

	private final static String LEFT_ROUND = "(";
	private final static String RIGHT_ROUND = ")";
	private final static String LEFT_ANGLE = "[";
	private final static String RIGHT_ANGLE = "]";
	
	private static class ArrayStack {
		private int top;
		private int maxSize;
		private Object[] stackArray;
		
		public ArrayStack(int maxSize) {
			this.maxSize = maxSize;
			this.stackArray = new Object[maxSize];
			this.top = -1;
		}
		
		public boolean empty() {
			return this.top == -1;
		}
		
		public boolean full() {
			return this.top == this.maxSize - 1;
		}
		
		public void push(Object item) {
			if(full()) {
				throw new ArrayIndexOutOfBoundsException((this.top+1) + ">=" + this.maxSize);
			}
			stackArray[++top] = item;
		}
		
		public Object peak() {
			if(empty()) {
				throw new ArrayIndexOutOfBoundsException(top);
			}
			return stackArray[top];
		}
		
		public Object pop() {
			Object item = peak();
			top--;
			return item;
		}
	}
	
	private static int calculate(ArrayStack stack) {
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		String[] parenthesises = null;
		while((str = br.readLine()) != null) {
			parenthesises = str.split(""); // parenthesis[0] = "" 이므로 주의
			break;
		}
		
		ArrayStack stack = new ArrayStack(parenthesises.length - 1);
		int value = 0;
		int lRoundNum = 0;
		int rRoundNum = 0;
		int lAngleNum = 0;
		int rAngleNum = 0;
		for(int i=1;i<parenthesises.length;i++) {
			String item = parenthesises[i];
			if(RIGHT_ANGLE.equals(item)) {
				
			}else if(RIGHT_ROUND.equals(item)) {
				
			}else {
				stack.push(item);
			}
		}
		
		bw.write(String.valueOf(value));
		bw.flush();
		br.close();
		bw.close();
	}
}
