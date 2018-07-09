package algorithm.baekjoon.stepwise.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		int[] numArr = new int[testNum];
		int sum = 0;
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		int maxFreq = 0;
		for(int i=0;i<testNum;i++) {
			numArr[i] = Integer.parseInt(scn.nextLine());
			sum += numArr[i];
			if(freqMap.containsKey(numArr[i])) {
				int freq = freqMap.get(numArr[i]);
				if(freq + 1 > maxFreq)
					maxFreq = freq + 1;
				freqMap.remove(numArr[i]);
				freqMap.put(numArr[i], freq + 1);
			}else {
				freqMap.put(numArr[i], 1);
				if(1 > maxFreq)
					maxFreq = 1;
			}
		}
		List<Integer> maxFreqList = new ArrayList<Integer>();
		Iterator<Integer> iter = freqMap.keySet().iterator();
		while(iter.hasNext()) {
			int freq = iter.next();
			if(freqMap.get(freq) == maxFreq)
				maxFreqList.add(freq);
		}
		Object[] maxFreqArr = maxFreqList.toArray();
		Arrays.sort(maxFreqArr);
		Arrays.sort(numArr);
		double mean = (double) sum / testNum;
		int median = numArr[testNum / 2];
		int coverage = numArr[testNum - 1] - numArr[0];
		int mode = 0;
		if(maxFreqArr.length == 1)
			mode = (int) maxFreqArr[0];
		else
			mode = (int) maxFreqArr[1];
		System.out.printf("%.0f", mean);
		System.out.println("");
		System.out.println(median);
		System.out.println(mode);
		System.out.println(coverage);
		
	}
}
