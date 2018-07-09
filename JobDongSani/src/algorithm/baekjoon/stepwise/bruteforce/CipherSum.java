package algorithm.baekjoon.stepwise.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CipherSum {
	
	public static int sumOfCipher(int num) {
		int sum = 0;
		char[] chArr = String.valueOf(num).toCharArray();
		for(int i=0;i<chArr.length;i++)
			sum += Integer.parseInt(String.valueOf(chArr[i]));
		return sum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int givenNum = 0;
		while((str = br.readLine()) != null) {
			givenNum = Integer.parseInt(str);
			break;
		}
		int cipherCnt = str.length();
		int start = 0;
		if(givenNum > cipherCnt * 9)
			start = givenNum - cipherCnt * 9;
		boolean doesExist = false;
		for(int i=start;i<givenNum;i++) {
			if(i + sumOfCipher(i) == givenNum) {
				bw.write(String.valueOf(i));
				doesExist = true;
				break;
			}
		}
		if(doesExist == false)
			bw.write("0");
		bw.flush();
		br.close();
		bw.close();
	}
}
