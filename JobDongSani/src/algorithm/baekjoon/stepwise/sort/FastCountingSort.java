package algorithm.baekjoon.stepwise.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class FastCountingSort {

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		OutputStreamWriter wt = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(wt);
		
		int testNum = 0;
		String str = null;
		int index =0;
		int maxNum = 0;
		Map<Integer, Integer> countingMap = new HashMap<Integer, Integer>();
		try {
			int[] givenNums = null;
			while((str = br.readLine()) != null) {
				if(testNum == 0) {
					testNum = Integer.parseInt(str);
					givenNums = new int[testNum];
				}else {
					givenNums[index] = Integer.parseInt(str);
					if(maxNum < givenNums[index])
						maxNum = givenNums[index];
					if(countingMap.containsKey(givenNums[index])) {
						int count = countingMap.get(givenNums[index]);
						countingMap.remove(givenNums[index]);
						countingMap.put(givenNums[index], count + 1);
					}else
						countingMap.put(givenNums[index], 1);
					index++;
					if(index == testNum)
						break;
				}
			}
			int[] countingArr = new int[maxNum + 1];
			int countSum = 0;
			for(int i=0;i<countingArr.length;i++) {
				if(countingMap.containsKey(i))
					countSum += countingMap.get(i);
				countingArr[i] = countSum;
			}
			int[] sortedArr = new int[testNum];
			for(int i=testNum-1;i>=0;i--) {
				sortedArr[countingArr[givenNums[i]] - 1] = givenNums[i];
				countingArr[givenNums[i]]--;
			}
			for(int i=0;i<testNum;i++) {
				bw.write((String.valueOf(sortedArr[i])));
				bw.newLine();
			}
			bw.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null) try {br.close();}catch(IOException e) {}
			if(rd != null) try {rd.close();}catch(IOException e) {}
			if(bw != null) try {bw.close();}catch(IOException e) {}
			if(wt != null) try {wt.close();}catch(IOException e) {}
		}
	}
}
