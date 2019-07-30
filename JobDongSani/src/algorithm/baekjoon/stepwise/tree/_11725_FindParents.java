package algorithm.baekjoon.stepwise.tree;

import java.io.*;

public class _11725_FindParents {
	private static int N = 0;
	private static int[] parents = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		while((str = br.readLine()) != null){
			if(N == 0){
				N = Integer.parseInt(str);
			}
		}
	}
}
