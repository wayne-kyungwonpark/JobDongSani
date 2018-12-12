package algorithm.baekjoon.stepwise.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sort3 {

//	private static long[] makePartialSum(long[] count) {
//		long[] partialSum = new long[count.length];
//		partialSum[0] = count[0];
//		for(int i=1;i<count.length;i++) {
//			partialSum[i] = partialSum[i - 1] + count[i];
//		}
//		return partialSum;
//	}
	
	private static void makePartialSum(long[] count) {
		for(int i=1;i<count.length;i++) {
			count[i] = count[i - 1] + count[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		long num = 0;
		long testFreq = 0;
		long[] ori = null, count = null, partialSum = null, sorted = null;
		while((str = br.readLine()) != null) {
			if(num == 0) {
				num = Long.parseLong(str);
//				ori = new long[(int) num];
				count = new long[10001];
//				partialSum = new long[(int) num + 1];
				sorted = new long[(int) num];
			}else {
//				ori[(int) testFreq] = Long.parseLong(str);
				count[Integer.parseInt(str)]++;
				testFreq++;
			}
			if(num == testFreq) {
				break;
			}
		}
		
//		partialSum = makePartialSum(count);
		makePartialSum(count);
		
//		for(int i=1;i<partialSum.length;i++) {
//			if(partialSum[i - 1] != partialSum[i]) {
//				for(int j=(int) partialSum[i - 1];j<partialSum[i];j++) {
//					sorted[j] = i;
//				}
//			}
//		}
		
		for(int i=1;i<count.length;i++) {
			if(count[i - 1] != count[i]) {
				for(int j=(int) count[i - 1];j<count[i];j++) {
					sorted[j] = i;
				}
			}
		}
		
		for(int i=0;i<sorted.length;i++) {
			bw.write(String.valueOf(sorted[i]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
