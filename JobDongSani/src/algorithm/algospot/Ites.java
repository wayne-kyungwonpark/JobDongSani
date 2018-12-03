package algorithm.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Ites {

	private static final long START = 1983;
	private static long prev;
	
	private static long rsg() {
		long mod = (long) 1 << 32;
		long tmp = (prev * 214013) % mod;
		long next = (tmp + 2531011) % mod;
		prev = next;
		return next;
	}
	
	private static int count(long n, long k) {
		int num = 0;
		prev = START;
		LinkedList<Long> queue = new LinkedList<Long>();
		long rangeSum = 0;
		for(int i=0;i<n;i++) {
			prev = rsg();
			long newSignal = prev % 10000 + 1;
			rangeSum += newSignal;
			queue.addLast(newSignal);
			
			while(rangeSum > k) {
				rangeSum -= queue.getFirst();
				queue.removeFirst();
			}
			
			if(rangeSum == k) {
				num++;
			}
		}
		return num;
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
				String[] strArr = str.split(" ");
				long k = Long.parseLong(strArr[0]);
				long n = Long.parseLong(strArr[1]);
				bw.write(String.valueOf(count(n, k)));
				bw.newLine();
				if(testNum == testFreq) {
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
