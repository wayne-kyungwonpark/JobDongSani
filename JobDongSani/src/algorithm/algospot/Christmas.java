package algorithm.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Christmas {

	private static int[] partialSum;
	private static Map<Integer, List<Integer>> sameCheck;
	private static int[] maxBuyMem;
	
	private static int order(int children) {
		int len = partialSum.length;
		int order = 0;
		Set<Integer> partialSumSet = sameCheck.keySet();
		Iterator<Integer> iter = partialSumSet.iterator();
		while(iter.hasNext()) {
			int count = sameCheck.get(iter.next()).size();
			if(count >= 2) {
				order += count * (count - 1) / 2;
				if(order > 20091101) {
					order %= 20091101;
				}
			}
		}
		if(partialSumSet.contains(0)) {
			order += sameCheck.get(0).size();
		}
		return order;
	}
	
	private static int maxBuys(int i) {
		if(i == 0) {
			if(partialSum[i] == 0) {
				maxBuyMem[i] = 1;
				return 1;
			}else {
				maxBuyMem[i] = 0;
				return 0;
			}
		}
		int k = -1;
		for(int j=i;j>=0;j--) {
			if(j != 0 && partialSum[j - 1] == partialSum[i]) {
				k = j;
				break;
			}else if(j == 0 && partialSum[i] == 0) {
				k = j;
				break;
			}
		}
		
//		int size = sameCheck.get(partialSum[i]).size();
//		if(size >= 2) {
//			for(int j=size-1;j>=0;j--) {
//				if(sameCheck.get(partialSum[i]).get(j) < i) {
//					k = sameCheck.get(partialSum[i]).get(j) + 1;
//					break;
//				}
//			}
//		}else {
//			if(partialSum[i] == 0) {
//				k = 0;
//			}
//		}
		
		if(k == 0) {
			if(maxBuyMem[i - 1] == -1) {
				maxBuyMem[i - 1] = maxBuys(i - 1);
			}
			return Math.max(maxBuyMem[i - 1], 1);
		}else if(k == -1){
			if(maxBuyMem[i - 1] == -1) {
				maxBuyMem[i - 1] = maxBuys(i - 1);
			}
			return maxBuyMem[i - 1];
		}else {
			if(maxBuyMem[i - 1] == -1) {
				maxBuyMem[i - 1] = maxBuys(i - 1);
			}
			if(maxBuyMem[k - 1] == -1) {
				maxBuyMem[k - 1] = maxBuys(k - 1);
			}
			return Math.max(maxBuyMem[i - 1], maxBuyMem[k - 1] + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0, testFreq = 0;
		int toyBox = 0, children = 0, caseFreq = 0;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				String[] strArr = str.split(" ");
				if(toyBox == 0) {
					toyBox = Integer.parseInt(strArr[0]); children = Integer.parseInt(strArr[1]);
				}else {
					partialSum = new int[toyBox];
					sameCheck = new HashMap<Integer, List<Integer>>();
					maxBuyMem = new int[toyBox];
					for(int i=0;i<toyBox;i++) {
						maxBuyMem[i] = -1;
					}
					
					partialSum[0] = Integer.parseInt(strArr[0]) % children;
					sameCheck.put(partialSum[0], new ArrayList<Integer>());
					sameCheck.get(partialSum[0]).add(0);
					for(int i=1;i<toyBox;i++) {
						partialSum[i] = (partialSum[i - 1] + Integer.parseInt(strArr[i])) % children;
						if(!sameCheck.containsKey(partialSum[i])) {
							List<Integer> arrList = new ArrayList<Integer>();
							arrList.add(i);
							sameCheck.put(partialSum[i], arrList);
						}else {
							sameCheck.get(partialSum[i]).add(i);
						}
					}
				}
				caseFreq++;
				if(caseFreq == 2) {
					bw.write(String.valueOf(order(children)) + " " + String.valueOf(maxBuys(toyBox - 1)));
					bw.newLine();
					partialSum = null;
					toyBox = 0; children = 0; caseFreq = 0;
					testFreq++;
				}
			}
			if(testFreq >= testNum) {
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
