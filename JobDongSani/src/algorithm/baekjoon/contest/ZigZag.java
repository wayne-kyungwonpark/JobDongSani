package algorithm.baekjoon.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ZigZag {

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		OutputStreamWriter wt = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(wt);
		
		String str = null;
		int iter = 0;
		int seqLen = 0;
		String[] nums = null;
		try {
			while((str = br.readLine()) != null) {
				if(iter == 0)
					seqLen = Integer.parseInt(str);
				else
					nums = str.split(" ");
				if(iter == 1)
					break;
				iter++;
			}
			int zigZagCount = 2;
			for(int start=0;start<seqLen-2;start++) {
				int tmpCount = 2;
				boolean isPlus = false;
				for(int i=start;i<seqLen-2;i++) {
					int num1 = Integer.parseInt(nums[i]);
					int num2 = Integer.parseInt(nums[i + 1]);
					int num3 = Integer.parseInt(nums[i + 2]);
					if(i == start) {
						if(num1 < num2 && num2 > num3) {
							isPlus = true;
							tmpCount++;
						}else if(num1 > num2 && num2 < num3) {
							isPlus = false;
							tmpCount++;
						}else {
							break;
						}
					}else {
						if((num1 < num2 && num2 > num3) && !isPlus) {
							tmpCount++;
							isPlus = true;
						}else if((num1 > num2 && num2 < num3) && isPlus) {
							tmpCount++;
							isPlus = false;
						}else {
							break;
						}
					}
				}
				if(zigZagCount < tmpCount)
					zigZagCount = tmpCount;
			}
			bw.write(String.valueOf(zigZagCount));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();}catch(IOException e) {}
			if(rd != null) try {rd.close();}catch(IOException e) {}
			if(bw != null) try {bw.close();}catch(IOException e) {}
			if(wt != null) try {wt.close();}catch(IOException e) {}
		}
	}
}
