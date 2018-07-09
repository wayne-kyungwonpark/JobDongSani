package algorithm.baekjoon.stepwise.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Build {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int index = 0;
		String str = null;
		int cnt = 0;
		List<Integer> weights = new ArrayList<Integer>();
		List<Integer> heights = new ArrayList<Integer>();
		String[] whPair = new String[2];
		while((str = br.readLine()) != null) {
			if(index == 0)
				cnt = Integer.parseInt(str);
			else {
				whPair = str.split(" ");
				weights.add(Integer.parseInt(whPair[0]));
				heights.add(Integer.parseInt(whPair[1]));
			}
			index++;
			if(index == cnt + 1)
				break;
		}
		for(int i=0;i<cnt;i++) {
			int grade = 1;
			int weight = weights.get(i);
			int height = heights.get(i);
			for(int j=0;j<cnt;j++) {
				if(i != j && ((weight < weights.get(j) && height < heights.get(j))))
					grade++;
			}
			bw.write(String.valueOf(grade));
			if(i != cnt - 1)
				bw.write(" ");
		}		
		bw.flush();
		br.close();
		bw.close();
	}
}
