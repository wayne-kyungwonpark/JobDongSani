package algorithm.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Brackets2 {
	
	private static boolean isOpen(String bracket) {
		if("(".equals(bracket) || "{".equals(bracket) || "[".equals(bracket)) {
			return true;
		}else {
			return false;
		}
	}
	
	private static String findPair(String bracket) {
		if(")".equals(bracket)) {
			return "(";
		}else if("}".equals(bracket)) {
			return "{";
		}else {
			return "[";
		}
	}
	
	private static String isTrue(String brackets) {
		char[] chArr = brackets.toCharArray();
		LinkedList<String> stack = new LinkedList<String>();
		for(int i=0;i<chArr.length;i++) {
			String bracket = String.valueOf(chArr[i]);
			if(isOpen(bracket)) {
				stack.addLast(bracket);
			}else {
				String pair = findPair(bracket);
				if(stack.isEmpty() || !pair.equals(stack.getLast())) {
					return "NO";
				}else {
					stack.removeLast();
				}
			}
		}
		if(stack.isEmpty()) {
			return "YES";
		}else {
			return "NO";
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
				testFreq++;
				bw.write(isTrue(str));
				bw.newLine();
				if(testFreq == testNum) {
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
