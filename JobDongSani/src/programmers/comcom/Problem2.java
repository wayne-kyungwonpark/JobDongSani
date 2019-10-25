package programmers.comcom;

import java.util.HashMap;

public class Problem2 {
    public int[] solution(int[] truck, int[] w) {
        int[] answer = new int[w.length];
        HashMap<Integer, Integer> wTMap = new HashMap<>();

        int overlapped = 1;
        boolean increment = true;
        int decrementIndex = 0;
        for (int i = 0; i < truck.length + w.length - 1; i++) {
            for (int j = decrementIndex; j < overlapped + decrementIndex; j++) {
                if (truck[i - j] >= w[j] && w[j] != 0) {
                    truck[i - j] -= w[j];
                    w[j] = 0;
                    wTMap.put(j, i - j + 1);
                }
            }
            if(i + 2 >= Math.min(truck.length, w.length) && i + 2 <= Math.max(truck.length, w.length)){
                overlapped = Math.min(truck.length, w.length);
            }else{
                if(i + 2 < Math.min(truck.length, w.length)){
                    overlapped++;
                }else{
                    overlapped--;
                    decrementIndex++;
                }
            }
        }

        for (int i = 0; i < w.length; i++) {
            if(wTMap.containsKey(i)){
                answer[i] = wTMap.get(i);
            }else{
                answer[i] = -1;
            }
        }
        return answer;
    }
}
