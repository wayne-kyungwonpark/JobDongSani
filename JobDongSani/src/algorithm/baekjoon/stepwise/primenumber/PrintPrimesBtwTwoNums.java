package algorithm.baekjoon.stepwise.primenumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrintPrimesBtwTwoNums {

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		OutputStreamWriter wt = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(wt);
		String str = null;
		String[] strArr = null;
		try {
			while((str = br.readLine()) != null) {
				strArr = str.split(" ");
				break;
			}
			int num1 = Integer.parseInt(strArr[0]);
			int num2 = Integer.parseInt(strArr[1]);
			for(int i=num1;i<=num2;i++) {
				if(i != 1) {
					boolean isPrime = true;
					for(int j=2;j<(int)Math.sqrt(i)+1;j++) {
						if(i % j == 0 && i != j) {
							isPrime = false;
							break;
						}
					}
					if(isPrime) {
						bw.write(String.valueOf(i));
						bw.newLine();
					}
				}
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();}catch(IOException e) {}
			if(rd != null) try {rd.close();}catch(IOException e) {}
			if(bw != null) try {bw.close();}catch(IOException e) {}
			if(wt != null) try {wt.close();}catch(IOException e) {}
		}
	}
}
