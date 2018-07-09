package algorithm.baekjoon.stepwise.primenumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GoldbachConjecture {
	
	private static boolean isPrime(int num) {
		for(int j=2;j<(int)Math.sqrt(num)+1;j++) {
			if(num % j == 0 && num != j)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		OutputStreamWriter wt = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(wt);
		String str = null;
		try {
			int testNum = 0;
			boolean isFirst = true;
			int countTestNum = 1;
			while((str = br.readLine()) != null) {
				if(isFirst) {
					testNum = Integer.parseInt(str);
					isFirst = false;
				}else {
					int num = Integer.parseInt(str);
					for(int i=num/2;i>=2;i--) {
						int diff = num - i;
						if(isPrime(i) && isPrime(diff)) {
							StringBuffer sb = new StringBuffer("");
							sb.append(String.valueOf(i)).append(" ").append(String.valueOf(diff));
							bw.write(sb.toString());
							bw.newLine();
							break;
						}
					}
					if(testNum == countTestNum)
						break;
					else
						countTestNum++;
				}
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();}catch(IOException e) {};
			if(rd != null) try {rd.close();}catch(IOException e) {};
			if(bw != null) try {bw.close();}catch(IOException e) {};
			if(wt != null) try {wt.close();}catch(IOException e) {};
		}
	}
}
