package algorithm.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class HamburgerDiet {

	private static int[] score;
	private static int[] cal;
	private static float[] scorePerCal;
	private static List<Integer> rankIndexArr; // rankIndexArr.get(0) 에 있는 값이 scorePerCal이 가장 높은 인덱스
	
	// Greedy로 풀었으나 최적의 해는 나오지 않았다...
	private static int findOptimum(int materialNum, int calLimit) {
		int calSum = 0;
		int scoreSum = 0;
		for(int i=0;i<materialNum;i++) {
			if(calSum + cal[rankIndexArr.get(i)] <= calLimit) {
				calSum += cal[rankIndexArr.get(i)];
				scoreSum += score[rankIndexArr.get(i)];
			}
		}
		return scoreSum;
	}
	
	private static void makeRankIndexArr(int materialFreq) {
		if(materialFreq == 0) {
			rankIndexArr.add(0, materialFreq);
		}else {
			for(int i=0;i<materialFreq;i++) {
				if(scorePerCal[rankIndexArr.get(i)] < scorePerCal[materialFreq]) {
					rankIndexArr.add(i, materialFreq);
					break;
				}else if(scorePerCal[rankIndexArr.get(i)] == scorePerCal[materialFreq]) {
					if(cal[rankIndexArr.get(i)] < cal[materialFreq]) {
						rankIndexArr.add(i, materialFreq);
						break;
					}
				}
				if(i == materialFreq - 1) {
					rankIndexArr.add(materialFreq);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int testFreq = 0;
		int materialNum = 0;
		int materialFreq = 0;
		int calLimit = 0;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				if(materialNum == 0) {
					String[] strArr = str.split(" ");
					materialNum = Integer.parseInt(strArr[0]);
					calLimit = Integer.parseInt(strArr[1]);
					score = new int[materialNum];
					cal = new int[materialNum];
					scorePerCal = new float[materialNum];
					rankIndexArr = new ArrayList<Integer>();
				}else {
					String[] strArr = str.split(" ");
					score[materialFreq] = Integer.parseInt(strArr[0]);
					cal[materialFreq] = Integer.parseInt(strArr[1]);
					scorePerCal[materialFreq] = (float) score[materialFreq] / cal[materialFreq];
					makeRankIndexArr(materialFreq);
					materialFreq++;
				}
				if(materialFreq == materialNum) {
					for(int i=0;i<rankIndexArr.size();i++) {
						System.out.println(rankIndexArr.get(i));
					}
					testFreq++;
					int totalScore = findOptimum(materialNum, calLimit);
					StringBuilder sb = new StringBuilder();
					sb.append("#").append(String.valueOf(testFreq)).append(" ").append(String.valueOf(totalScore));
					bw.write(sb.toString());
					bw.newLine();
					materialNum = 0;
					materialFreq = 0;
					calLimit = 0;
					score = null;
					cal = null;
					scorePerCal = null;
					rankIndexArr = null;
				}
			}
			if(testNum == testFreq) {
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
