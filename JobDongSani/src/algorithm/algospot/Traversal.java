package algorithm.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Traversal {

	private static List<Integer> slice(List<Integer> list, int a, int b){
		return list.subList(a, b);
	}
	
	private static void printPostOrder(BufferedWriter bw, 
			List<Integer> preOrder, List<Integer> inOrder) throws IOException {
		int nodeNum = preOrder.size();
		if(preOrder.isEmpty()) {
			return;
		}
		int root = preOrder.get(0);
		for(int i=0;i<inOrder.size();i++) {
			if(inOrder.get(i) == root) {
				printPostOrder(bw, slice(preOrder, 1, 1 + i), slice(inOrder, 0, i));
				printPostOrder(bw, slice(preOrder, 1 + i, preOrder.size()), 
						slice(inOrder, 1 + i, inOrder.size()));
				break;
			}
		}
		
		bw.write(String.valueOf(root) + " ");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0, testFreq = 0;
		int nodeNum = 0, inCaseFreq = 0;
		List<Integer> preOrder = null, inOrder = null;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				if(nodeNum == 0) {
					nodeNum = Integer.parseInt(str);
				}else {
					String[] strArr = str.split(" ");
					if(inCaseFreq == 0) {
						preOrder = new ArrayList<Integer>();
						for(int i=0;i<strArr.length;i++) {
							preOrder.add(Integer.parseInt(strArr[i]));
						}
					}else {
						inOrder = new ArrayList<Integer>();
						for(int i=0;i<strArr.length;i++) {
							inOrder.add(Integer.parseInt(strArr[i]));
						}
					}
					inCaseFreq++;
					if(inCaseFreq == 2) {
						testFreq++;
						printPostOrder(bw, preOrder, inOrder);
						bw.newLine();
						nodeNum = 0; inCaseFreq = 0; preOrder = null; inOrder = null;
					}
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
