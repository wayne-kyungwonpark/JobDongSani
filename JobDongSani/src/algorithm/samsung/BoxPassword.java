package algorithm.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class BoxPassword {
	
	private static int N, K, L;
	private static LinkedList<String> passwords;
	private static int checkIndex;
	private static boolean checkBefore;
	private static boolean checkAfter;
	
	private static long sixToTen(String password) {
		long num = 0;
		char[] chArr = password.toCharArray();
		for(int i=password.length()-1;i>=0;i--) {
			long mul = 0;
			if('A' == chArr[i]) mul = 10; else if('B' == chArr[i]) mul = 11;
			else if('C' == chArr[i]) mul = 12; else if('D' == chArr[i]) mul = 13;
			else if('E' == chArr[i]) mul = 14; else if('F' == chArr[i]) mul = 15;
			else mul = Long.parseLong(String.valueOf(chArr[i]));
			num += (Math.pow(16, password.length() - 1 - i) * mul);
		}
		return num;
	}
	
	// password < listElem -> false
	// password > listElem -> true
	private static boolean isAfter(String password, String listElem) {
		char[] passArr = password.toCharArray();
		char[] elemArr = listElem.toCharArray();
		for(int i=0;i<password.length();i++) {
			if(passArr[i] == elemArr[i]) {
				continue;
			}else if(passArr[i] > elemArr[i]) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	private static void nextDecision(String password) {
		char[] chArr = password.toCharArray();
		for(int i=0;i<password.length()-1;i++) {
			if(chArr[i] == chArr[i + 1]) {
				if(i == password.length() - 2) {
					checkBefore = false;
					checkAfter = false;
				}
				continue;
			}else if(chArr[i] < chArr[i + 1]) {
				checkBefore = false;
				checkAfter = true;
				break;
			}else {
				checkBefore = true;
				checkAfter = false;
				break;
			}
		}
	}
	
	private static void insertPassword(String password) {
		if(passwords.isEmpty()) {
			passwords.add(password);
			checkIndex = 0;
			nextDecision(password);
		}else {
			if(!passwords.contains(password)) {
				if(!checkBefore && !checkAfter) {
					if(isAfter(password, passwords.get(checkIndex))) {
						checkAfter = true;
					}else {
						checkBefore = true;
					}
				}
				if(checkBefore) {
					if(checkIndex == 0) {
						passwords.addFirst(password);
						checkIndex = 0;
					}else {
						for(int i=checkIndex-1;i>=0;i--) {
							if(!isAfter(password, passwords.get(i))) {
								if(i == 0) {
									passwords.addFirst(password);
									checkIndex = 0;
									break;
								}
								continue;
							}else {
								passwords.add(i + 1, password);
								checkIndex = i + 1;
								break;
							}
						}
					}
				}else if(checkAfter) {
					if(checkIndex == passwords.size() - 1) {
						passwords.addLast(password);
						checkIndex = passwords.size() - 1;
					}else {
						for(int i=checkIndex+1;i<passwords.size();i++) {
							if(isAfter(password, passwords.get(i))) {
								if(i == passwords.size() - 1) {
									passwords.addLast(password);
									checkIndex = passwords.size() - 1;
									break;
								}
							}else {
								passwords.add(i, password);
								checkIndex = i;
								break;
							}
						}
					}
				}
			}else {
				checkIndex = passwords.indexOf(password);
			}
			nextDecision(password);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0, testFreq = 0, inCaseFreq = 0;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				if(inCaseFreq == 0) {
					String[] strArr = str.split(" ");
					N = Integer.parseInt(strArr[0]);
					K = Integer.parseInt(strArr[1]);
					L = N / 4;
					inCaseFreq++;
				}else {
					testFreq++;
					passwords = new LinkedList<String>();
					str = str + str;
					for(int i=0;i<N;i++) {
						insertPassword(str.substring(i, i + L));
					}
//					for(int i=passwords.size()-1;i>=0;i--) {
//						bw.write(passwords.get(i) + " ");
//					}
					bw.write("#" + testFreq + " " + String.valueOf(sixToTen(passwords.get(passwords.size() - K))));
					bw.newLine();
					inCaseFreq = 0;
					N = 0; K = 0; L = 0;
					passwords = null;
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
