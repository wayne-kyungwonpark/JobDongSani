package algorithm.baekjoon.stepwise.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class _1966_PrinterQueue {
	private static int testNum = 0;
	private static int N = 0, M = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int testFreq = 0;
		StringBuilder sb = new StringBuilder();
		while((str = br.readLine()) != null){
			if(testNum == 0){
				testNum = Integer.parseInt(str);
			}else{
				String[] strArr = str.split(" ");
				if(N == 0){
					N = Integer.parseInt(strArr[0]);
					M = Integer.parseInt(strArr[1]);
				}else{
					sb.append(doTestCase(strArr));
					N = 0; M = 0;
					testFreq++;
					if(testFreq == testNum){
						break;
					}else{
						sb.append("\n");
					}
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int doTestCase(String[] strArr) {
		int result = 0;
		LinkedList<Integer> importances = new LinkedList<>();
		for(int i = 0; i < strArr.length; i++){
			importances.add(Integer.parseInt(strArr[i]));
		}
		LinkedList<Integer> documents = makeInitDocuments(N);
		boolean isPrinted = false;
		while(!isPrinted){
			boolean doesExist = false;
			int importance = importances.getFirst();
			for(int i = 1; i < importances.size(); i++){
				if(importances.get(i) > importance){
					doesExist = true;
					break;
				}
			}
			if(doesExist){
				documents.add(documents.getFirst());
				documents.removeFirst();
				importances.add(importances.getFirst());
				importances.removeFirst();
			}else{
				result++;
				if(documents.getFirst() == M){
					isPrinted = true;						
				}
				documents.removeFirst();
				importances.removeFirst();
			}
		}
		return result;
	}
	
	private static LinkedList<Integer> makeInitDocuments(int N){
		LinkedList<Integer> documents = new LinkedList<>();
		for(int i = 0; i < N; i++){
			documents.add(i);
		}
		return documents;
	}
}
