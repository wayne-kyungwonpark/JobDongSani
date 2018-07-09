package algorithm.baekjoon.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PalindromeSubStrings {

	private static boolean isPalindrome(String subStr) {
		boolean isTrue = true;
		int start = 0;
		int end = subStr.length() - 1;
		while(start <= end) {
			if(!Character.toString(subStr.charAt(start)).equals(Character.toString(subStr.charAt(end)))) {
				isTrue = false;
				break;
			}
			start++;
			end--;
		}
		return isTrue;
	}
	
	private static int numOfPalindrome(String query) {
		int count = query.length();
		for(int num=2;num<=query.length();num++) {
			for(int i=0;i<query.length()-num+1;i++) {
				if(isPalindrome(query.substring(i, i+num)))
					count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		OutputStreamWriter wt = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(wt);
		
		String str = null;
		int iter = 0;
		int queryLen = 0;
		String totalQuery = null;
		try {
			while((str = br.readLine()) != null) {
				if(iter == 0)
					queryLen = Integer.parseInt(str);
				else
					totalQuery = new String(str);
				if(iter == 1)
					break;
				iter++;			
			}
			char[] chArr = totalQuery.toCharArray();
			StringBuffer sb = new StringBuffer("");
			for(int i=0;i<queryLen;i++) {
				String tmpStr = Character.toString(chArr[i]);
				if(!"-".equals(tmpStr))
					sb.append(tmpStr);
				else
					sb.deleteCharAt(sb.length() - 1);
				bw.write(String.valueOf(numOfPalindrome(sb.toString())));
				if(i != queryLen - 1)
					bw.write(" ");
			}
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
