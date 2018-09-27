package algorithm.baekjoon.contest.snu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class PrimitivePythagorasNumber {

	private static long[][] gcds;
	private static long gcdVal;
	private static long globalM;
	private static long globalN;
	
	private static ArrayList<Long> mList;
	private static ArrayList<Long> nList;
	
	private static long gcd(long m, long n) {
		mList.add(m);
		nList.add(n);
		if(n == 0) {
			gcdVal = m;
			return m;
		}else {
			long tmp = m % n;
			if(gcds[(int) n][(int) (tmp)] != 0) {
				gcdVal = gcds[(int) n][(int) (tmp)];
				return gcdVal;
			}else {
				return gcd(n, tmp);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		long max = 0;
		while((str = br.readLine()) != null) {
			max = Long.parseLong(str);
			break;
		}
		gcds = new long[(int) max + 1][(int) max + 1];
		long startTime = System.currentTimeMillis();
		long num = 0;
		for(long i=2;i<=max;i++) {
			if(i % 2 == 0) {
				for(long j=1;j<i;j+=2) {
					globalM = i;
					globalN = j;
					mList = new ArrayList<Long>();
					nList = new ArrayList<Long>();
					long tmpGcd = gcd(i, j);
					for(int k=0;k<mList.size();k++) {
						gcds[mList.get(k).intValue()][nList.get(k).intValue()] = gcdVal;
					}
					if(tmpGcd == 1) {
//						bw.write(String.valueOf(i) + " " + String.valueOf(j));
//						bw.newLine();
						num++;
					}
				}
			}else {
				for(long j=2;j<i;j+=2) {
					globalM = i;
					globalN = j;
					mList = new ArrayList<Long>();
					nList = new ArrayList<Long>();
					long tmpGcd = gcd(i, j);
					for(int k=0;k<mList.size();k++) {
						gcds[mList.get(k).intValue()][nList.get(k).intValue()] = gcdVal;
					}
					if(tmpGcd == 1) {
//						bw.write(String.valueOf(i) + " " + String.valueOf(j));
//						bw.newLine();
						num++;
					}
				}
			}
		}
		long endTime = System.currentTimeMillis();
		bw.write(String.valueOf(num));
		bw.newLine();
		bw.write(String.valueOf((endTime - startTime) / 1000));
		bw.flush();
		bw.close();
		br.close();
	}
}
