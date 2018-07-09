package algorithm.baekjoon.stepwise.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class NonDivisibleByPerfectNumber {

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		OutputStreamWriter wt = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(wt);
		
		String str = null;
		String nums[] = null;
		try {
			while((str = br.readLine()) != null) {
				nums = str.split(" ");
				while(nums.length < 2)
					nums = str.split(" ");
				if(nums.length == 2)
					break;
			}
			long num1 = Long.parseLong(nums[0]);
			long num2 = Long.parseLong(nums[1]);
			long check = (long) Math.sqrt(num2) + 1;
			int[] checkPrimes = new int[(int)check + 1];
			checkPrimes[0] = 1;
			checkPrimes[1] = 1;
			for(int i=2;i<checkPrimes.length;i++) {
				int j = i;
				if(checkPrimes[j] == 0) {
					j += i;
					while(j < checkPrimes.length) {
						checkPrimes[j] = 1;
						j += i;
					}
				}
			}
			List<Integer> primes = new ArrayList<Integer>();
			for(int i=0;i<checkPrimes.length;i++) {
				if(checkPrimes[i] == 0)
					primes.add(i);
			}
//			for(int i=0;i<checkPrimes.length;i++) {
//				if(checkPrimes[i] == 0) {
//					bw.write(String.valueOf(i) + ": ");
//					bw.write(String.valueOf(checkPrimes[i]));
//					bw.write(", ");
//				}
//			}
			long count = 0;
			long count1 = 0;
			long count2 = 0;
			for(int j=1;j<=primes.size();j++) {
				for(int i=0;i<primes.size();i++) {
					count1 += num1 / primes.get(i);
				}
			}
//			for(long i=num1;i<=num2;i++) {
//				boolean isDivisible = false;
//				for(int j=0;j<primes.size();j++) {
//					int primeSquare = primes.get(j) * primes.get(j);
//					if(i % primeSquare == 0) {
//						isDivisible = true;
//						break;
//					}
//				}
//					
////				if(i % 4 == 0)
////					isDivisible = true;
////				else {
////					for(int j=3;j<checkPrimes.length;j+=2) {
////						if(checkPrimes[j] == 0 && i % (j * j) == 0) {
////							isDivisible = true;
////							break;
////						}
////					}
////				}
//				if(!isDivisible)
//					count++;
//			}
			bw.write(String.valueOf(count));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();} catch(IOException e) {}
			if(rd != null) try {rd.close();} catch(IOException e) {}
			if(bw != null) try {bw.close();} catch(IOException e) {}
			if(wt != null) try {wt.close();} catch(IOException e) {}
		}
	}
}
