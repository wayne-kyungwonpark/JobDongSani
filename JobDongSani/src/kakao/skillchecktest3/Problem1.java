package kakao.skillchecktest3;

import java.util.ArrayList;

public class Problem1 {
	public int[][] solution(int n) {
		int nums = (int) Math.pow(2, n) - 1;
		int[][] answer = new int[nums][2];
		
		ArrayList<Integer> starts = new ArrayList<>();
		ArrayList<Integer> ends = new ArrayList<>();
		
		doHanoi(n, starts, ends, 1, 2, 3);
		
		for(int i = 0; i < starts.size(); i++){
			answer[i][0] = starts.get(i);
			answer[i][1] = ends.get(i);
		}
		
		return answer;
	}

	private void doHanoi(int level, ArrayList<Integer> starts, ArrayList<Integer> ends, int start, int middle, int end) {
		if(level == 1){
			starts.add(start);
			ends.add(end);
			return;
		}
		doHanoi(level - 1, starts, ends, start, end, middle);
		starts.add(start);
		ends.add(end);
		doHanoi(level - 1, starts, ends, middle, start, end);
	}
}
