package algorithm.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Josephus {

	private static String findTwoSites(String str) {
		String[] strArr = str.split(" ");
		int n = Integer.parseInt(strArr[0]);
		int k = Integer.parseInt(strArr[1]);
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		int index = 0;
		while(list.size() > 2) {
			if(index >= list.size()) {
				index %= list.size();
			}
			list.remove(index);
			index += (k - 1);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0)).append(" ").append(list.get(1));
		return sb.toString();
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
				bw.write(findTwoSites(str));
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
