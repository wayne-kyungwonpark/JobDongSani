package algorithm.baekjoon.stepwise.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FindLargestFreqAlpha {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[] wordArr = scn.nextLine().toCharArray();
		Map<String, Integer> checkMap = new HashMap<String, Integer>();
		for(int i=0;i<wordArr.length;i++) {
			String alpha = Character.toString(wordArr[i]).toUpperCase();
			if(checkMap.containsKey(alpha)) {
				int freq = checkMap.get(alpha);
				checkMap.remove(alpha);
				checkMap.put(alpha, freq+1);
			}else
				checkMap.put(alpha, 1);
		}
		boolean isSameFreq = false;
		String mostFreqAlpha = "?";
		int mostFreqNum = 0;
		for(Entry<String, Integer> entry : checkMap.entrySet()) {
			String key = entry.getKey();
			int freqNum = entry.getValue();
			if(freqNum > mostFreqNum) {
				mostFreqAlpha = key;
				mostFreqNum = freqNum;
				isSameFreq = false;
			}else if(freqNum == mostFreqNum)
				isSameFreq = true;
		}
		if(!isSameFreq)
			System.out.println(mostFreqAlpha);
		else
			System.out.println("?");
	}
}
