package algorithm.baekjoon.contest.snu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PrimitivePythagorasNumber2 {

	private static final long MAX_VALUE = 5000000000l;
//	private static final long MAX_VALUE = 121;
	private static ArrayList<Long> primes;
	
	private static boolean isPrime(long num) {
		long checkValue = (long) Math.sqrt(num);
		for(long i=3;i<=checkValue;i+=2) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void findPrimes() { // sqrt(5000000000) 이하의 모든 소수 찾기
		long rootValue = (long) Math.sqrt(MAX_VALUE);
		primes = new ArrayList<Long>();
		primes.add(2l);
		for(long i=3;i<=rootValue;i+=2) {
			if(isPrime(i)) {
				primes.add(i);
			}
		}
	}
	
	private static List<Long> primeFactor(long m) { // m의 소인수 리스트
		List<Long> primeFactors = new ArrayList<Long>();
		for(long i=0;i<primes.size();i++) {
			long tmp = primes.get((int) i);
			if(tmp > m) {
				break;
			}else if(m % tmp == 0) {
				primeFactors.add(tmp);
			}
		}
		return primeFactors;
	}
	
	private static long numRelativelyPrimes(long m, List<Long> primeFactors) {
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		long max = 0;
		while((str = br.readLine()) != null) {
			max = Long.parseLong(str);
			break;
		}
		long num = 0;
		findPrimes();
		for(long m=2;m<=max;m++) {
			List<Long> primeFactors = primeFactor(m);
			if(m % 2 == 0) {
				num++; // n = 1 일때
				for(long n=3;n<m;n+=2) {
					boolean isDivisible = false;
					for(int i=0;i<primeFactors.size();i++) {
						long tmpPrime = primeFactors.get(i);
						if(tmpPrime > n) {
							break;
						}else if(n % tmpPrime == 0) {
							isDivisible = true;
							break;
						}
					}
					if(!isDivisible) {
//						bw.write(String.valueOf(m) + " " + String.valueOf(n));
//						bw.newLine();
						num++;
					}
				}
			}else {
				for(long n=2;n<m;n+=2) {
					boolean isDivisible = false;
					for(int i=0;i<primeFactors.size();i++) {
						long tmpPrime = primeFactors.get(i);
						if(tmpPrime > n) {
							break;
						}else if(n % tmpPrime == 0) {
							isDivisible = true;
							break;
						}
					}
					if(!isDivisible) {
//						bw.write(String.valueOf(m) + " " + String.valueOf(n));
//						bw.newLine();
						num++;
					}
				}
			}
		}
		bw.write(String.valueOf(num));
//		for(long i=0;i<primes.size();i++) {
//			bw.write(String.valueOf(primes.get((int) i)));
//			bw.newLine();
//		}
//		bw.write(String.valueOf(primes.size()));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
