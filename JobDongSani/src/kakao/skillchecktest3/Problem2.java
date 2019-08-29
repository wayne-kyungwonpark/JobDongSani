package kakao.skillchecktest3;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2 {
	public int solution(int n, int[][] costs) {
        Comparator<int[]> c1 = new Comparator<int[]>(){
        	@Override
        	public int compare(int[] a, int[] b){
        		return a[2] - b[2];
        	}
        };
        
        Arrays.sort(costs,c1);
        
        boolean[] check = new boolean[costs.length];
        boolean[] ok = new boolean[n];
        ok[costs[0][0]] = true;
        ok[costs[0][1]] = true;
        check[0] = true;
        
        int answer = costs[0][2];
        int complete = 2;

        while(complete < n) {
        	for(int i=1;i<check.length;i++) {
        		if(!check[i] && ((ok[costs[i][0]]&&!ok[costs[i][1]])||(ok[costs[i][1]]&&!ok[costs[i][0]]))) {
        			check[i] = true;
        			ok[costs[i][0]] = true;
        			ok[costs[i][1]] = true;
        			complete++;
        			answer+=costs[i][2];
        			break;
    			}
    		} 
    	}

        return answer;
    }
}
