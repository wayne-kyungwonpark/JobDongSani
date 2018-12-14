package algorithm.baekjoon.stepwise.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class RadixSort {

	/**
	 * radix sort 를 위한 자릿수대로 Queue의 배열에 넣음
	 * @param radix
	 * @param exp (정렬 기준 자릿수, 1(=1의자리), 2(=10의자리), ... )
	 * @param ori
	 */
	private static void fillRadix(LinkedList<Integer>[] radix, int exp, int[] ori) {
		int mod = (int) Math.pow(10, exp);
		for(int i=0;i<ori.length;i++) {
			radix[(ori[i] / mod) % 10].offer(ori[i]);
		}
	}
	
	/**
	 * Queue의 배열 (radix) 에 있는 대로 정렬
	 * @param radix
	 * @param ori
	 */
	private static void radixSort(LinkedList<Integer>[] radix, int[] ori) {
		int index = 0;
		for(int i=0;i<radix.length;i++) {
			while(!radix[i].isEmpty()) {
				ori[index++] = radix[i].poll();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		long testNum = 0;
		long testFreq = 0;
		
		// Queue를 LinkedList를 사용하여 구현
		LinkedList<Integer>[] radix = new LinkedList[10];
		for(int i=0;i<10;i++) {
			radix[i] = new LinkedList<Integer>();
		}
		
		int[] ori = null;
		
		int max = 0;
		
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Long.parseLong(str);
				ori = new int[(int) testNum];
			}else {
				int num = Integer.parseInt(str);
				if(num > max) {
					max = num;
				}
				ori[(int) testFreq] = num;
				testFreq++;
			}
			if(testNum == testFreq) {
				break;
			}
		}
		
		int exp = 0;
		int maxExp = String.valueOf(max).length() - 1;
		for(int i=exp;i<=maxExp;i++) {
			fillRadix(radix, i, ori);
//			long mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//			System.out.println(mem1);
			radixSort(radix, ori);
//			long mem2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//			System.out.println(mem2);
			for(int j=0;j<10;j++) {
				radix[j] = new LinkedList<Integer>();
			}
		}
		
		for(int i=0;i<ori.length;i++) {
			bw.write(String.valueOf(ori[i]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
